import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N;
	static boolean[][] visited;
	
	static class Pos{
		int r, c;
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		int min = 100;
		int max = 1;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(board[i][j], min);
				max = Math.max(board[i][j], max);
			}
		}
		
		int maxCnt = 0;
		
		for(int h=min-1;h<=max;h++) {
			//높이마다 방문배열 초기화
			visited = new boolean[N][N];
			
			//높이 h일때 잠기는 칸 모두 방문표시
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(board[i][j]<=h) visited[i][j] = true;
				}
			}

			//방문안한 그룹개수 세기
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						bfs(i,j, visited);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		
		System.out.println(maxCnt);
	}

	private static void bfs(int i, int j, boolean[][] visited) {
		Queue<Pos> q2 = new LinkedList<>();
		q2.add(new Pos(i,j));
		
		visited[i][j]=true;
		
		while(!q2.isEmpty()) {
			Pos curr = q2.poll();
			for(int d=0;d<4;d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q2.add(new Pos(nr,nc));
			}
		}
	}

}