import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int T;
    static int N;
    static boolean[][] arr;
    static boolean[][] visited;
    static int click;
    static int[] dr = {-1,1,0,0,-1,-1,1,1}; //상하좌우, 좌상, 우상, 좌하, 우하
    static int[] dc = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                String tmpr = br.readLine();
                for (int c = 0; c < N; c++) {
                    arr[r][c] = tmpr.charAt(c) == '*';
                }
            }


            visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (arr[r][c]) visited[r][c] = true;
                }
            }

            click = 0;
            //1. 클릭할때 0으로 나오는 애들을 연쇄적으로 먼저 처리
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!arr[r][c] && !visited[r][c] && findBomb(r, c) == 0) { //지뢰 아니고 숫자 안보이고 클릭시 0값 나오는 칸
                        bfs(r, c);
                    }
                }
            }

            //2. 나머지 처리
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!arr[r][c] && !visited[r][c]) { //지뢰 아니고 숫자 안보이는 칸
                        click++;
                        visited[r][c] = true;
                    }
                }
            }

//            for (int r = 0; r < N; r++) {
//                System.out.println(Arrays.toString(visited[r]));
//            }

            System.out.println("#" + tc + " " + click);
        }

    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;
        click++;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            if(findBomb(cr,cc)==0){
                for(int d=0;d<8;d++){
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];

                    if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                    if(arr[nr][nc]) continue;
                    if(visited[nr][nc]) continue;

                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }

    static int findBomb(int r, int c){
        int cnt = 0;
        for(int d=0;d<8;d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
            if(arr[nr][nc]) cnt++;
        }
        return cnt;
    }
}
