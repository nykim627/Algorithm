import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static List<Pos>[][] roads;
	static int N, K, R; //정사각형 목초지 N×N (2 ≤ N ≤ 100), 소 K마리, 길 R개
	static Pos[] cows;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pos{
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        //각 칸마다 연결되어 있는 길 입력
        roads = new ArrayList[N+1][N+1];
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		roads[i][j] = new ArrayList();
        	}
        }
        
        for(int i=0;i<R;i++) {
        	st = new StringTokenizer(br.readLine());
        	int r1 = Integer.parseInt(st.nextToken());
        	int c1 = Integer.parseInt(st.nextToken());
        	int r2 = Integer.parseInt(st.nextToken());
        	int c2 = Integer.parseInt(st.nextToken());
        	roads[r1][c1].add(new Pos(r2,c2));
        	roads[r2][c2].add(new Pos(r1,c1));
        }
        
        //소 위치 입력
        cows = new Pos[K];
        for(int i=0;i<K;i++) {
        	st = new StringTokenizer(br.readLine());
        	int r1 = Integer.parseInt(st.nextToken());
        	int c1 = Integer.parseInt(st.nextToken());
        	cows[i] = new Pos(r1,c1);
        }
        
        //각 소마다 bfs 실행
        int sum = 0;
        for(int i=0;i<K;i++) {
        	sum += bfs(cows[i]);
        }
        
        //현재 sum은 a기준 b못만남 + b기준 a못만남 둘 다 있으므로 나누기 2해줘야 함
        sum /= 2;
        
        System.out.println(sum);
        
	}

	private static int bfs(Pos pos) {
		Queue<Pos> q = new LinkedList();
		boolean[][] visited = new boolean[N+1][N+1];
		q.add(pos);
		visited[pos.r][pos.c]= true;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			for(int d=0;d<4;d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(nr<1||nr>N||nc<1||nc>N) continue;
				if(isRoad(curr,nr,nc)) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.add(new Pos(nr,nc));
			}
		}
		
		int sum = 0;
		for(int i=0;i<K;i++) {
			if(!visited[cows[i].r][cows[i].c]) sum++;
		}
		
		return sum;
	}

	private static boolean isRoad(Pos curr, int nr, int nc) {
		for(Pos e: roads[curr.r][curr.c]) {
			if(e.r==nr&&e.c==nc) return true;
		}
		return false;
	}
    
}