import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int n, g, h;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] edges;
	
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		boolean passedG, passedH; //해당 경로마다 g, h 지나는지 확인
		public Edge(int to, int cost, boolean g, boolean h) {
			this.to = to;
			this.cost = cost;
			this.passedG = g;
			this.passedH = h;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=0;tc<T;tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken()); //교차로 수
    		int m = Integer.parseInt(st.nextToken()); //도로 수
    		int t = Integer.parseInt(st.nextToken()); //목적지 후보 수
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken()); //출발지
    		g = Integer.parseInt(st.nextToken()); //g에서 h사이 반드시 지남
    		h = Integer.parseInt(st.nextToken()); 
    		
    		edges = new ArrayList[n+1];
    		for(int i=1;i<=n;i++) {
    			edges[i] = new ArrayList();
    		}
    		for(int i=0;i<m;i++) {
    			st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			int d = Integer.parseInt(st.nextToken());
    			edges[a].add(new Edge(b,d, false, false));
    			edges[b].add(new Edge(a,d, false, false)); //양방향
    		}
    		
    		int[] ends = new int[t];
    		for(int i=0;i<t;i++) {
    			ends[i] = Integer.parseInt(br.readLine());
    		}
    		Arrays.sort(ends); //목적지 후보 배열 오름차순 정렬
    		
    		int[] distS = dijkstra(s);
    		int[] distG = dijkstra(g);
    		int[] distH = dijkstra(h);
//    		System.out.println(distG[h]+"=="+distH[g]);
    		
    		for(int i=0;i<t;i++) {
    			int total = distS[ends[i]];
    			int SG = distS[g];
    			int GH = distG[h];
    			int HE = distH[ends[i]];
    			int SH = distS[h];
    			int GE = distG[ends[i]];
    			if((total==SG+GH+HE)||(total==SH+GH+GE)){
    				sb.append(ends[i]).append(" ");
    			}
    		}
    		
    		sb.append("\n");
    		
    	}//tc
    	
    	System.out.println(sb.toString());
    }

	private static int[] dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue(); //간선 저장 pq
		pq.add(new Edge(start,0, false, false));
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			//꺼낸 경로의 거리보다 이미 더 짧은 거리로 방문한 적이 있다면, 지금 꺼낸 경로는 무시
			if(curr.cost>dist[curr.to]) continue; 
			
			for(Edge e: edges[curr.to]) {
				if(dist[e.to] > dist[curr.to]+e.cost) {
					dist[e.to] = dist[curr.to]+e.cost; //최소값 갱신
					boolean passG=curr.passedG, passH=curr.passedH;
					if(e.to==g) {
						passG = true;
					}else if(e.to==h) {
						passH = true;
					}
					pq.add(new Edge(e.to, dist[e.to], passG, passH));
				}
			}
		}
		
		return dist;
	}
}