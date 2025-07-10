import java.util.*;
import java.io.*;

public class Main
{
    static boolean[][] visited;
    static int N, M, K;
    static boolean[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[M][N];
            visited = new boolean[M][N];
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
            }

            int cnt = 0;
            for(int r=0;r<M;r++){
                for(int c=0;c<N;c++){
                    if(!map[r][c] || visited[r][c]) continue;
                    dfs(r,c);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
		
        }

        System.out.println(sb.toString());
	}


    static void dfs(int r, int c){
        visited[r][c] = true;

        for(int d=0;d<4;d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr<0 || nc<0 || nr>=M || nc>=N) continue;
            if(!map[nr][nc] || visited[nr][nc]) continue;
            dfs(nr,nc);
        }
    }
}