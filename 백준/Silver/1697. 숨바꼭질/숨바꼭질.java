import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs인걸 몰랐다면 과연 할 수 있었을까...?라는 의문이 드는 문제
public class Main {
	static int N, K, X;
	static int[] dc;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = N;
		dc = new int[] {-1,1,X};
		
		visited = new int[100001];
		Arrays.fill(visited, -1);
		
		bfs(N);
		
		
		System.out.println(visited[K]);

	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList();
		q.add(start);
		visited[start] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr==K) {
				return;
			}
			dc[2] = curr;
			for(int d=0;d<3;d++) {
				 int nc = curr + dc[d];
				 if(nc<0 || nc>=100001) continue;
				 if(visited[nc]!=-1) continue;
//				 System.out.println(nc);
				 visited[nc] = visited[curr] + 1;
				 q.offer(nc);
			}
		}
		
	}
}
