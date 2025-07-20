import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N; //col, row
	static int[][] visited; //거리배열
	static ArrayList<Point> ripeArrList;
	static int[][] map; //농장
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Point{
		int r;
		int c;
		public Point(int x, int y) {
			this.r = x;
			this.c = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(visited[i], -1);
		}
		
		boolean hasRaw = false;
		ripeArrList = new ArrayList();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) hasRaw = true;
				else if(map[i][j]==1) ripeArrList.add(new Point(i,j));
				else if(map[i][j]==-1) visited[i][j] = 0;
			}
		}
		
		if(!hasRaw) sb.append(0);
		else {
			bfs(ripeArrList);
			int max = 0;
			boolean stillHasRaw = false;
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(visited[r][c]==-1) {
						stillHasRaw = true;
						break;
					}
					max = Math.max(max, visited[r][c]);
				}
			}
			if(stillHasRaw) sb.append(-1);
			else sb.append(max);
		}
		
		
		System.out.println(sb.toString());
	}

	private static void bfs(ArrayList<Main.Point> arrList) {
		Queue<Point> q = new LinkedList();
		for(Point e: arrList) {
			q.add(e);
			visited[e.r][e.c] = 0; 
		}
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			for(int d=0;d<4;d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(map[nr][nc]==-1) continue;
				if(visited[nr][nc]!=-1) continue;
				visited[nr][nc] = visited[curr.r][curr.c] + 1;
				q.add(new Point(nr,nc));
			}
		}
		
	}
}
