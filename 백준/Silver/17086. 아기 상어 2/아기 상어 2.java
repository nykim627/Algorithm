import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//2차원 다익스트라
class Main {
	static int N, M;
	static boolean[][] arr;
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
        	}
        }
        
        int maxSafe = 0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(arr[i][j]) continue;
        		int safeDist = bfs(i,j);
        		maxSafe = Math.max(maxSafe, safeDist);
        	}
        }
        
        System.out.println(maxSafe);
    }
    
	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque();
		q.add(new int[] {i,j});
		int[][] dist = new int[N][M];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				dist[r][c] = -1;
			}
//			Arrays.fill(dist, -1);
		}
		dist[i][j] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(arr[curr[0]][curr[1]]) return dist[curr[0]][curr[1]];
			for(int d=0;d<8;d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(dist[nr][nc]!=-1) continue;
				dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
				q.add(new int[] {nr,nc});
			}
		}
		return 0;
	}
}