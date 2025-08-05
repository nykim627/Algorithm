import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

class Main {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, M;
    static ArrayList<Edge> edges;
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<Edge>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }
        bellmanFord(1);
    }

    static void bellmanFord(int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 1. 모든 간선을 (N-1)번 직접 반복 ("정점개수-1"만큼!)
        for (int i = 1; i < N; i++) {
            boolean flag = false; // 갱신 일어남 여부
            for (Edge e : edges) { //간선 개수(M)만큼
                // 갱신 : (1)출발점이 무한대가 아닌 애들만! && (2)가중치 더한 거리가 더 작은 경우
                if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                    flag = true;
                }
            } // 사이클 1번 끝
            if (!flag)
                break; // 갱신이 일어나지 않았다면 조기종료
        }

        // 2. 음수사이클 췍 (한번 더 사이클을 돈다)
        boolean negativeCycle = false;
        for (Edge e : edges) {
            // 위의 조건문을 만족한다면 갱신이 일어났다는 것! -> 음의 사이클이 존재한다!
            if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                negativeCycle = true;
            }
        }

        // 3. 결과 확인
        if (negativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                System.out.println(dist[i] == INF ? -1 : dist[i]);
            }
        }
    }
}