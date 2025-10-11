import java.util.*;
import java.io.*;

class Main{
    static class Edge implements Comparable<Edge>{
        int to, w;
        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o){
            return this.w - o.w;
        }
    }
    
    static int N, M;
    static ArrayList<Edge>[] arrList;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //도시
        M = Integer.parseInt(br.readLine()); //버스
        
        arrList = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arrList[i] = new ArrayList<Edge>();
        }
        
        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrList[from].add(new Edge(to,w));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dijkstra(start, end);
        
        System.out.println(dist[end]);
    }
    
    public static void dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(curr.to==end) return;
            for(Edge e: arrList[curr.to]){
                if(dist[curr.to]+e.w < dist[e.to]){
                    dist[e.to] = dist[curr.to]+e.w;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
    }
}