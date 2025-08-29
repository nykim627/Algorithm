import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, canTellCnt, cannotTellCnt;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		canTellCnt = 0;
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				System.out.println(visited[i][j]);
				if(visited[i][j]) continue;
				bfs(i,j,visited,board[i][j]);
				canTellCnt++;
			}
		}
		
		cannotTellCnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j]=='G') board[i][j]='R';
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				System.out.println(visited[i][j]);
				if(visited[i][j]) continue;
				bfs(i,j,visited,board[i][j]);
				cannotTellCnt++;
			}
		}
		
		System.out.println(canTellCnt+" "+cannotTellCnt);
		
	}

	private static void bfs(int i, int j, boolean[][] visited, char color) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			for(int d=0;d<4;d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(visited[nr][nc]) continue;
				if(board[nr][nc]!=color) continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
		}		
	}
	
}