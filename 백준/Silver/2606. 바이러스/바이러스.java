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
	static int N, V;
	static boolean[] visited;
	static ArrayList<Integer>[] arrList;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		V = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		arrList = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arrList[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<V;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrList[a].add(b);
			arrList[b].add(a);
		}
		
		dfs(1);
		
		sb.append(cnt-1);

		System.out.println(sb.toString());
	}
	private static void dfs(int start) {
		visited[start] = true;
		cnt++;
		
		for(int e: arrList[start]) {
			if(visited[e]) continue;
			dfs(e);
		}
		
	}
}
