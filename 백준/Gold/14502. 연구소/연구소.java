import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백트래킹 -> 브루트포스보다 시간복잡도 훨씬 줄어듦
class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, M, ans;
	static ArrayList<Pos> virus;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus = new ArrayList<>();
		
		board = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==2) virus.add(new Pos(i,j));
			}
		}
		
		//dfs+백트래킹으로 벽 3개를 조합
		buildWalls(0,0);
		
		System.out.println(ans);
		
	}
	
	private static void buildWalls(int count, int start) {
		//재귀 종료 조건
		if(count==3) {
			int[][] b = new int[N][M];
			for(int i=0;i<N;i++) b[i] = board[i].clone();
			
			bfs(b);
			
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(b[i][j]==0) cnt++;
//					System.out.println(cnt);
				}
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		//dfs 재귀
		for(int i=start;i<N*M;i++) {
			int r = i/M;
			int c = i%M;
			if(board[r][c]==0) {
				board[r][c] = 1; //벽으로 만들어봄
				buildWalls(count+1, i+1);
				board[r][c] = 0; //백트래킹(롤백)
			}
		}
		
		
	}

	static class Pos{
		int r,c;
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	private static void bfs(int[][] board) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for(Pos e: virus) {
			q.add(e);
			visited[e.r][e.c] = true;
		}
		
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