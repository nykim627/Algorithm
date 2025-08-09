import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static ArrayList<Pos> arrList;
	static int[][] map;
	
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new int[9][9];
        arrList = new ArrayList<>();  //new ArrayList(); 는 raw type 경고. new ArrayList<>()로.
        for(int i=0;i<9;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<9;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j]==0) arrList.add(new Pos(i,j));
        	}
        }
        
        backTrackingDfs(0); // 해를 찾으면 map에 그대로 남음
        
        for(int i=0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		sb.append(map[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
	private static boolean backTrackingDfs(int idx) {
		if(idx>=arrList.size()) return true; // 모든 빈칸 채움 → 성공
		
		Pos curr = arrList.get(idx);
		Loop:
		for(int num=1;num<=9;num++) {
			for(int i=0;i<9;i++) {
				if(map[i][curr.y]==num) continue Loop;
				if(map[curr.x][i]==num) continue Loop;
			}
			int k=curr.x/3, l=curr.y/3;
			for(int i=k*3;i<(k+1)*3;i++) {
				for(int j=l*3;j<(l+1)*3;j++) {
				 	if(map[i][j]==num) continue Loop;
				}
			}
			map[curr.x][curr.y] = num; 			
			if(backTrackingDfs(idx+1)) return true; // 성공 전파
			map[curr.x][curr.y]= 0;   				// 실패 시 되돌리기
		}
		return false; // 이 칸에서 어떤 수로도 불가능
	}    
}