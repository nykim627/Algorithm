import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o){
			return this.cost-o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] arrList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			arrList[i] = new ArrayList();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arrList[from].add(new Edge(to, cost));
		}
		
		int[] dist = dijkstra(K, V, arrList);
		
		for(int i=1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}

	private static int[] dijkstra(int start, int N, ArrayList<Edge>[] arrList) {
		PriorityQueue<Edge> pq = new PriorityQueue();
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			for(Edge e: arrList[curr.to]) {
				if(dist[e.to] > dist[curr.to]+e.cost) {
					dist[e.to] = dist[curr.to]+e.cost;
					pq.add(new Edge(e.to, dist[e.to]));
				}
				
			}
		}
		
		return dist;
	}

}
