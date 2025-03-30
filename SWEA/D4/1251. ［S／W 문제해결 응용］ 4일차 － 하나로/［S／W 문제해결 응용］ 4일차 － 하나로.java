import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {
    static int N; //섬의 개수
    static int[] p;
    static List<int[]> combs;
    static int[] sel = new int[2]; //조합에서 선택된 배열


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
        int a, b; //섬 두 개의 비용과 환경부담금
        double cost;

        Edge(int a, int b, double cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "a=" + a +
                    ", b=" + b +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
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


            for(int i=0;i<N;i++){
                islands[i] = new Island(xs[i],ys[i]);
            }//섬의 좌표 채우기
            combs = new ArrayList<>();
            comb(0,0); //가능한 모든 조합 탐색 후 combs에 넣기
//            for(int i=0;i< combs.size();i++){
//                System.out.print(Arrays.toString(combs.get(i))+" ");
//            }
            Edge[] edges = new Edge[combs.size()];
            for(int i=0;i<combs.size();i++){
                int[] e = combs.get(i);
                int a = e[0]; int b = e[1];
                long squareL = (long) (islands[a].x - islands[b].x) *(islands[a].x - islands[b].x)+ (long)(islands[a].y - islands[b].y) *(islands[a].y-islands[b].y);
//                System.out.println(squareL);
                double cost = E * (double) squareL;
                edges[i] = new Edge(a,b,cost);
            }//간선 배열 채우기

            Arrays.sort(edges); //간선배열 환경부담금 기준 오름차순 정렬
//            System.out.println(Arrays.toString(edges));

            double sum = 0;
            p = new int[N];
            for(int i=0;i<N;i++){
                p[i] = i; //makeset 잊지마!!
            }
            for(int i=0, pick=0;i<edges.length && pick<N-1;i++){
                int px = findset(edges[i].a);
                int py = findset(edges[i].b);
                if(px!=py) {
                    pick++;
                    sum += edges[i].cost;
                    union(px,py);
                }
            }

            long ans = Math.round(sum);

            sb.append(ans).append("\n");

        }//tc끝

        System.out.println(sb.toString());

    }//main

    static void comb(int n, int m){
        if(m==2){
            int[] tmp = Arrays.copyOf(sel,2);
            combs.add(tmp); return;
        }
        if(n>=N) return;

        sel[m] = n;
        comb(n+1,m+1); //뽑
        comb(n+1,m); //안뽑
    }

    static void union(int x, int y){
        p[y] = x;
    }

    static int findset(int x){
        if(x!=p[x]){
            p[x] = findset(p[x]);
        }
        return p[x];
    }


}
