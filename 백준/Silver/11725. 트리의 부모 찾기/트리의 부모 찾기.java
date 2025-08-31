import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs + 방문배열 + ArrayDeque
//루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
class Main {
	static int[] parent; //부모배열이자 방문배열(0아니면 방문한거)
	static List<Integer>[] arrList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arrList = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			arrList[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrList[a].add(b);
			arrList[b].add(a); //일단 양방향으로 [부모] : 자식1, 자식2, ...
		}
		
		bfs(1);
		
		for(int i=2;i<=N;i++) {
			System.out.println(parent[i]);
		}
		
	}

	private static void bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int child: arrList[p]) {
				if(visited[child]) continue;
				parent[child] = p; //첫 방문이면 부모 넣어주기
				visited[child] = true;
				q.add(child);
			}
		}
		
	}
}