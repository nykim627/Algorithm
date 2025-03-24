import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			List<Integer>[] adjList = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				adjList[b].add(a);
			} // 그래프 채워넣기 끝
//			System.out.println(Arrays.toString(adjList)); // 그래프 연결 확인용

			int cnt = 0; // 초대장을 받는 친구 수
			boolean[] visited = new boolean[N + 1]; // 각 친구에 대해 초대장을 받은 유무
			visited[1] = true; // 상원이는 초대장을 받았다고 치기.
			for (int i = 0; i < adjList[1].size(); i++) { // 상원이 친한친구들에 대해
				int friend = adjList[1].get(i);
				if (!visited[friend]) { // 만약 그 친구가 초대장 받지 않은 친구라면 초대장 +1
					cnt++;
					visited[friend] = true; // 그 친구는 이제 초대장을 받은 상태!
				}
				for (int j = 0; j < adjList[friend].size(); j++) { // 상원이 친한친구의 친한친구들에 대해
					int FofF = adjList[friend].get(j);
					if (!visited[FofF]) {
						cnt++; // 만약 그 친구가 초대장 받지 않은 친구라면 초대장 +1
						visited[FofF] = true; // 그 친구는 이제 초대장을 받은 상태!
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);

		} // tc순회
	}// main
}
