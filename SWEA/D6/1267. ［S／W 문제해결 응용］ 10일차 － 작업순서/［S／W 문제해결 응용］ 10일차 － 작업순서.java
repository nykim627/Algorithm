import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static Stack<Integer> stack;
	static int V, E;
	static List<Integer>[] adj; 
	static int[] degree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10; //tc수
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); //정점개수
			E = Integer.parseInt(st.nextToken()); //간선 수
			
			adj = new ArrayList[V+1];
			for(int i=1;i<=V;i++) {
				adj[i] = new ArrayList<>();
			}//초기화 완료
			degree = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int from = Integer.parseInt(st.nextToken()); //from정점
				int to = Integer.parseInt(st.nextToken()); //to정점
				adj[from].add(to);
				degree[to]++; //to정점의 진입차수 +1 하기
			}//간선입력
			
//			//확인용 출력
//			System.out.println(Arrays.toString(adj));
//			System.out.println(Arrays.toString(degree));
			
			visited = new boolean[V+1];
			stack = new Stack<>();
			for(int i=1;i<=V;i++) {
				if(degree[i]==0) dfs(i);
			}//처음에 진입노드 개수가 0인 애들 스택에 넣기
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			
			sb.append("\n");
			
		}//tc
		
		System.out.println(sb.toString());
		
	}

	private static void dfs(int v) {
		visited[v] = true;
		for(int e: adj[v]) {
			if(!visited[e]) dfs(e);
		}
		stack.push(v);
		
	}
}
