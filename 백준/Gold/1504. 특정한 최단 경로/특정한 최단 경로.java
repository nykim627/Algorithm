import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] edges;
	
	static class Edge implements Comparable<Edge>{
		int to, cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점 개수(2 ≤ N ≤ 800)
        int E = Integer.parseInt(st.nextToken()); //간선 개수(0 ≤ E ≤ 200,000)
        
        edges = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	edges[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<E;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken()); //a<->b 거리 (1 ≤ c ≤ 1,000)
        	edges[a].add(new Edge(b,c));
        	edges[b].add(new Edge(a,c)); //양방향
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int res1 = dijkstra(1,A) + dijkstra(A,B) + dijkstra(B,N); //1->A->B->N
        if(dijkstra(1,A)==-1||dijkstra(A,B)==-1||dijkstra(B,N)==-1) res1 = -1; // 세 경로 중 하나만 불가능이어도 전체가 불가능
        int res2 = dijkstra(1,B) + dijkstra(B,A) + dijkstra(A,N); //1->B->A->N
        if(dijkstra(1,B)==-1||dijkstra(B,A)==-1||dijkstra(A,N)==-1) res2 = -1;
        
//        System.out.println(res1+" "+res2);
        
        int finalRes = res1==-1||res2==-1 ? Math.max(res1, res2) : Math.min(res1, res2); //두 결과 중 하나가 불가능이라면 나머지 하나가 최소경로. 둘다 불가능이라면 -1.
        if(finalRes==-1) System.out.println(-1); //둘 다 불가능
        else System.out.println(finalRes);
        
    }
    
    static int dijkstra(int start, int end) {
    	PriorityQueue<Edge> pq = new PriorityQueue();
    	int[] dist = new int[N+1];
    	Arrays.fill(dist, INF);
    	
    	pq.offer(new Edge(start,0));
    	dist[start] = 0;
    	
    	while(!pq.isEmpty()) {
    		Edge curr = pq.poll();
    		if(curr.to==end) {
//    			System.out.println(dist[end]);
    			return dist[end];
    		}
    		
    		for(Edge e: edges[curr.to]) {
    			if(dist[e.to] > dist[curr.to]+ e.cost) {  //등호 포함 여부 확인하기
    				dist[e.to] = dist[curr.to] + e.cost;  
    				pq.offer(new Edge(e.to, dist[e.to]));
    			}
    		}
    	}
    	
    	return -1;
    }
}