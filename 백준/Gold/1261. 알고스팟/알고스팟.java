import java.util.*;
import java.io.*;


//0-1 BFS
class Main{
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, M;
	static int[][] dist; //벽 부순 횟수 담는 배열
	static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        int cntOnes=0;
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j] = str.charAt(j)-'0'; //빈방 0, 벽은 1
        	}
        }
        int res = bfs(0,0);
        
        System.out.println(res);
    }
    static class Pos{
    	int r, c;
    	Pos(int r, int c){
    		this.r = r;
    		this.c = c;
    	}
    	
    }
	private static int bfs(int i, int j) {
		Deque<Pos> dq = new ArrayDeque<>();  //0-1 bfs는 덱 사용.
		
		//빈칸(비용 0)은 addFirst, 벽(비용 1)은 addLast
		dq.addFirst(new Pos(i,j));
		dist = new int[N][M];
		for(int k=0;k<N;k++) {
			Arrays.fill(dist[k], INF); //dist 배열값 INF로 초기화
		}
		dist[i][j] = 0;
		
		while(!dq.isEmpty()) {
			Pos curr = dq.poll();
			if(curr.r==N-1&&curr.c==M-1) return dist[N-1][M-1];
			for(int d=0;d<4;d++) {
				int nr = curr.r+dr[d];
				int nc = curr.c+dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				int w = map[nr][nc]; //map[nr][nc] : 빈칸=0, 벽=1 -> 즉 벽이면 부순횟수 +1
				if(dist[nr][nc] > dist[curr.r][curr.c] + w) {  
					dist[nr][nc] = dist[curr.r][curr.c] + w;
					if(w==0) dq.addFirst(new Pos(nr,nc));
					else dq.addLast(new Pos(nr,nc));
				}
			}
		}
		return -1;
	}
}