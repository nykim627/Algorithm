import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static boolean[][] map;
	static int N, M;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class State implements Comparable<State>{
		int r, c, cost;
		boolean broke;
		State(int r, int c, int cost, boolean broke){
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.broke = broke;
		}
		
		@Override
		public int compareTo(State o) {
			return this.cost-o.cost;
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new boolean[N][M]; //(0,0) ~ (N-1, M-1)로 생각하기
        
        for(int r=0;r<N;r++) {
        	char[] lines = br.readLine().toCharArray();
        	for(int c=0;c<M;c++) {
        		char tmp = lines[c];
        		if(tmp=='1') map[r][c]=true; //벽인 경우만 true로 바꿈
        	}
        }
        
        int res = bfs();
        sb.append(res);

        System.out.println(sb.toString());
    }

	private static int bfs() {
		Queue<State> q = new LinkedList(); //pq 쓸 필요없음 
		boolean[][][] visited = new boolean[N][M][2]; //0:안부숨, 1:부숨
		q.add(new State(0,0,1,false)); //시작하는 칸부터 거리 1
		visited[0][0][0] = true; //벽부수지 않고 방문
		
		
		while(!q.isEmpty()) {
			State curr = q.poll();
			if(curr.r==N-1&&curr.c==M-1) return curr.cost;
			
			for(int d=0;d<4;d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(map[nr][nc]) { //벽이면
					if(!curr.broke&&!visited[nr][nc][1]) { //벽 아직 안부숨 & 다음방문장소를 벽부수지않고 방문한 적이 아직 없음
						visited[nr][nc][1] = true;
						q.add(new State(nr,nc,curr.cost+1,true));
					}
				}else {
					if(visited[nr][nc][curr.broke ? 1 : 0]) continue;
					visited[nr][nc][curr.broke ? 1 : 0] = true;
					q.add(new State(nr,nc,curr.cost+1,curr.broke));
				}
				
			}
		}
		
		return -1;
		
	}
}

