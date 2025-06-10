import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int num=0;
	static int[] order;
	static ArrayList<Integer>[] arrList;
	static int V, E, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arrList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			arrList[i] = new ArrayList();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arrList[from].add(to);
			arrList[to].add(from); //양방향
		}
		
		for(int i=1;i<=V;i++) {
			Collections.sort(arrList[i]);
//			Collections.reverse(arrList[i]);
		}
		
		visited = new boolean[V+1];
		order = new int[V+1];
		bfs(R);
		
		for(int i=1;i<=V;i++) {
			System.out.println(order[i]);
		}
		

	}

	private static void bfs(int r) {
		Queue<Integer> q = new LinkedList();
		q.add(r);
		visited[r] = true;
		order[r] = ++num;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int e: arrList[curr]) {
				if(!visited[e]) {
					visited[e] = true;
					order[e] = ++num;
					q.add(e);
				}
			}
		}
		
	}

}
