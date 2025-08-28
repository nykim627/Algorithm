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
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Pos> virus = new ArrayList<>();
		
		int[][] board = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==2) virus.add(new Pos(i,j));
			}
		}
		
		int ans = 0;
		for(int i=0;i<N*M;i++) {
			int r1 = i/M;
			int c1 = i%M;
			if(board[r1][c1]!=0) continue;
			for(int j=i+1;j<N*M;j++) {
				int r2 = j/M;
				int c2 = j%M;
				if(board[r2][c2]!=0) continue;
				for(int k=j+1;k<N*M;k++) {
					int r3 = k/M;
					int c3 = k%M;
					if(board[r3][c3]!=0) continue;
					int cnt = check(r1,c1,r2,c2,r3,c3,board,virus);
					ans = Math.max(cnt, ans);
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static class Pos{
		int r,c;
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	private static int check(int r1, int c1, int r2, int c2, int r3, int c3, int[][] board, ArrayList<Pos> virus) {
		int[][] b = new int[N][M];
		for(int i=0;i<N;i++) {
			b[i] = board[i].clone();
		}
		b[r1][c1] = 1;
		b[r2][c2] = 1;
		b[r3][c3] = 1;
		for(Pos e: virus) {
			bfs(e, b);
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(b[i][j]==0) cnt++;
//				System.out.println(cnt);
			}
		}
		return cnt;
	}

	private static void bfs(Main.Pos e, int[][] board) {
		Queue<Pos> q = new LinkedList<>();
		q.add(e);
		boolean[][] visited = new boolean[N][M];
		visited[e.r][e.c] = true;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			for(int d=0;d<4;d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(board[nr][nc]==1 || visited[nr][nc]) continue;
				board[nr][nc]=2;
				visited[nr][nc]=true;
				q.add(new Pos(nr,nc));
			}
		}
	}
}