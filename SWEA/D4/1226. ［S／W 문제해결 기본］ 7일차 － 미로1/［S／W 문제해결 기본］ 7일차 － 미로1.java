import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    static int start_r, start_c, end_r, end_c;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] maze;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){
            sb.append("#").append(tc).append(" ");

            //입력받기 시작
            int tcNum = Integer.parseInt(br.readLine());
            maze = new int[16][16];
            dist = new int[16][16];
            for(int r=0;r<16;r++){
                String str = br.readLine();
                for(int c=0;c<16;c++){
                    maze[r][c] = str.charAt(c) - '0';
                    if(maze[r][c]==2){
                        start_r = r;
                        start_c = c;
                    }else if(maze[r][c]==3){
                        end_r = r;
                        end_c = c;
                    }
                }
            }//미로입력끝
            int ans = bfs(start_r,start_c);
            sb.append(ans).append("\n");
        }//tc끝
        System.out.println(sb.toString());
    }//main

    private static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            if(cr==end_r&&cc==end_c){
                return 1;
            }
            for(int d=0;d<4;d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr<0||nc<0||nr>=16||nc>=16) continue;
                if(maze[nr][nc]==1) continue; //벽이면 쳐내
                if(dist[nr][nc]!=0) continue; //방문했으면 쳐내

                dist[nr][nc] = dist[cr][cc] + 1;
                q.add(new int[]{nr,nc});

            }
        }
        return 0;
    }
}
