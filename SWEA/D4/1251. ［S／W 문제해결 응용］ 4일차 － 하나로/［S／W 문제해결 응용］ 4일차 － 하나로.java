import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    static int N; //섬의 개수
    static List<Edge>[] adj;

    public static class Island{
        int x, y;

        Island(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Island{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static class Edge implements Comparable<Edge> {
        int to; //다음 섬의 번호와 환경부담금
        double cost;

        Edge(int to, double cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost,o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){
            sb.append("#").append(tc).append(" ");
            //입력받기 시작
            N = Integer.parseInt(br.readLine());
            Island[] islands = new Island[N];
            int[] xs = new int[N];
            int[] ys = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                xs[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                ys[i] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine()); //마지막에 환경부담세율 E 입력받음
            //입력받기 끝

            adj = new ArrayList[N];
            for(int i=0;i<N;i++){
                adj[i] = new ArrayList<>();
            }//초기화

            for(int i=0;i<N;i++){ //출발섬
                for(int j=i+1;j<N;j++){ //도착섬
                    double cost = E * (Math.pow(xs[i]-xs[j],2)+Math.pow(ys[i]-ys[j],2));
                    adj[i].add(new Edge(j,cost));
                    adj[j].add(new Edge(i,cost)); //무향이므로
                }
            }//그래프 표현 끝!

            double ans = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N];
            int pick = 0;
            pq.add(new Edge(0,0));
            while(pick<N){
                Edge e = pq.poll();
//                System.out.println(e.toString());
                if(visited[e.to]) continue;
                ans += e.cost;
                visited[e.to] = true;
                pick++;
                pq.addAll(adj[e.to]);
            }

            long res = Math.round(ans);

            sb.append(res).append("\n");

        }//tc끝

        System.out.println(sb.toString());

    }//main


}
