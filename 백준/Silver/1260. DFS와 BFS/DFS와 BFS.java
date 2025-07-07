import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점개수
		M = Integer.parseInt(st.nextToken()); //간선개수
		V = Integer.parseInt(st.nextToken()); //start
		
		arr = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a); //양방향
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(arr[i]); //방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
		}
		
		visited = new boolean[N+1];
		
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		

		System.out.println(sb.toString());
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			for(int e: arr[curr]) {
				if(visited[e]) continue;
				visited[e] = true;
				q.offer(e);
			}
		}
		
	}

	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for(int e: arr[start]) {
			if(visited[e]) continue;
			dfs(e);
		}
		
	}
}
