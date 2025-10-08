import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int[][] adjArr;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		adjArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			visited = new int[N];
			Arrays.fill(visited, -1);
			dfs(i,0);
			res[i] = visited.clone();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int tmp = res[i][j]<=0 ? 0 : 1;
				sb.append(tmp).append(" ");
//				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int v, int w) {
		visited[v] = w;
		for(int i=0;i<N;i++) {
			if(visited[i]>0) continue;
			if(adjArr[v][i]==0) continue;
			dfs(i, w+1);
		}
	}

}