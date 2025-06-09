import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X;
	static int[][] resArr;
	static int[][] arr;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 1,000
		M = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ 10,000
		X = Integer.parseInt(st.nextToken()); // 1 ≤ X ≤ N

		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		resArr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				resArr[i][j] = INF;
			}
		}
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, resArr[i][X] + resArr[X][i]);
		}

		System.out.println(max);
//		System.out.println(sb.toString());
	}

	private static void dijkstra(int i) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1];
		});

		boolean[] visited = new boolean[N + 1];

		resArr[i][i] = 0;
		pq.add(new int[] { i, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (visited[curr[0]] == true) {
				continue;
			}
			visited[curr[0]] = true;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && arr[curr[0]][j] > 0) {
					if (resArr[i][j] > resArr[i][curr[0]] + arr[curr[0]][j]) {
						resArr[i][j] = resArr[i][curr[0]] + arr[curr[0]][j];
						pq.add(new int[] { j, resArr[i][j] });
					}
				}
			}
		}

	}
}
