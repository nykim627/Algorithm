import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//상어가 있는 칸을 먼저 큐에 넣어두고 그 칸들부터 꺼내면서 bfs 돌기 + 방문표시
//=> 상어없이 방문한 칸은 가장 가까운 상어와의 최단거리가 저장됨
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
        Queue<int[]> q = new ArrayDeque();
        int[][] dist = new int[N][M];
		for(int r=0;r<N;r++) {
			Arrays.fill(dist[r], -1);
		}
		
		//bfs
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
        		if(arr[i][j]) {
        			q.add(new int[] {i,j});
        			dist[i][j] = 0;
        		}
        	}
        }
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<8;d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(dist[nr][nc]!=-1) continue;
				dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
				q.add(new int[] {nr,nc});
			}
		}
        
        int maxSafe = 0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(arr[i][j]) continue;
        		maxSafe = Math.max(maxSafe, dist[i][j]);
        	}
        }
        
        System.out.println(maxSafe);
    }
    
}