import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arrList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			arrList[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrList[a].add(b);
			arrList[b].add(a); //양방향
		}
		
		boolean[] visited = new boolean[V+1];
		int cnt = 0;
		for(int i=1;i<=V;i++) {
			if(visited[i]) continue;
			dfs(arrList,i,visited);
			cnt++;
		}
		
		System.out.println(cnt);
		
	}

	private static void dfs(ArrayList<Integer>[] arrList, int i, boolean[] visited) {
		for(int e : arrList[i]) {
			if(visited[e]) continue;
			visited[e] = true;
			dfs(arrList, e, visited);
		}
	}
}