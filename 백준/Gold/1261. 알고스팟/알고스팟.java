import java.util.*;
import java.io.*;

class Main{
	static boolean[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, M;
	static boolean[][][] visited; //[r][c][time] <- 벽 부순 횟수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j] = str.charAt(j)=='1' ? false : true;
        	}
        }
        visited = new boolean[N][M][N*M+10];
        bfs(0,0);
        
        int minTime = N*M;
        for(int i=0;i<N*M+10;i++) {
        	if(visited[N-1][M-1][i]) {
        		minTime = i;
        		break;
        	}
        }
        System.out.println(minTime);
    }
    static class Pos implements Comparable<Pos>{
    	int r, c, time;
    	Pos(int r, int c, int time){
    		this.r = r;
    		this.c = c;
    		this.time = time;
    	}
		@Override
		public int compareTo(Main.Pos o) {
			return this.time-o.time;
		}
    	
    }
	private static void bfs(int i, int j) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(i,j,0));
		visited[i][j][0] = true;
		
		while(!pq.isEmpty()) {
			Pos curr = pq.poll();
			if(curr.r==N-1&&curr.c==M-1) return;
			for(int d=0;d<4;d++) {
				int nr = curr.r+dr[d];
				int nc = curr.c+dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(!map[nr][nc]&&!visited[nr][nc][curr.time+1]) {
					visited[nr][nc][curr.time+1]=true;
					pq.add(new Pos(nr,nc,curr.time+1));
				}else if(map[nr][nc]&&!visited[nr][nc][curr.time]){
					visited[nr][nc][curr.time]= true;
					pq.add(new Pos(nr,nc,curr.time));
				}
			}
		}
	}
}