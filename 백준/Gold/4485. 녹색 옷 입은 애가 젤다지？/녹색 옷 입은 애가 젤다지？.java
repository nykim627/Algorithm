import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N;
    public static class Pos implements Comparable<Pos>{
        int r, c, w;
        Pos(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Pos o){
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int tc = 1;
        while(N!=0){
            sb.append("Problem ").append(tc++).append(": ");
            map = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int res = dijkstra(0,0);
            sb.append(res).append("\n");
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());
    }

    public static int dijkstra(int r, int c){
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(0,0,map[0][0]));
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        
        while(!pq.isEmpty()){
            Pos curr = pq.poll();
            if(curr.r==N-1&&curr.c==N-1){
                return curr.w;
            }
            for(int d=0;d<4;d++){
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];
                if(nr<0||nc<0||nr>=N||nc>=N) continue;
                if(visited[nr][nc]) continue; 
                visited[nr][nc]=true;
                pq.add(new Pos(nr,nc,curr.w+map[nr][nc]));
            }
        }
        return -1;
    }
}