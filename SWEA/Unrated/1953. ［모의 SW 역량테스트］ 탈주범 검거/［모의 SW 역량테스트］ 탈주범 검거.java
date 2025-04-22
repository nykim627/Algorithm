import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int T; //tc수
    static int N; //row크기
    static int M; //col크기
    static int R; //맨홀뚜껑의 row좌표
    static int C; //맨홀뚜껑의 col좌표
    static int L; //탈출 후 소요시간

    static int[][][] arr;
    static int[][] visited;

    public static int[] holeType(int num){
        int[] res = null;
        switch (num){
            case 0:
                res = new int[]{};
                break;
            case 1:
                res = new int[]{0,1,2,3};
                break;
            case 2:
                res = new int[]{0,1};
                break;
            case 3:
                res = new int[]{2,3};
                break;
            case 4:
                res = new int[]{0,3};
                break;
            case 5:
                res = new int[]{1,3};
                break;
            case 6:
                res = new int[]{1,2};
                break;
            case 7:
                res = new int[]{0,2};
                break;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][M][];
            visited = new int[N][M];
            for(int r=0;r<N;r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<M;c++){
                    arr[r][c] = holeType(Integer.parseInt(st.nextToken()));
                }
            }

            bfs(R,C); //맨홀위치 집어넣기

            int cnt = 0;
            for(int r=0;r<N;r++){
                for(int c=0;c<M;c++){
                    if(visited[r][c]<=L && visited[r][c]>0) cnt++;
                }
            }
//            System.out.println(Arrays.deepToString(visited));

            System.out.println("#"+tc+" "+cnt);

        }
        br.close();

    }//main

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});;
        visited[r][c]++;

        while(!q.isEmpty()){
            int[] curr = q.poll();
//            System.out.println(Arrays.toString(curr));
            int cr = curr[0];
            int cc = curr[1];
            for(int d : arr[cr][cc]){ //터널이 갈수 있는 방향만 확인
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(visited[nr][nc]>0) continue;
                boolean goNext = false;
//                System.out.println(Arrays.toString(arr[nr][nc]));
                for(int nd: arr[nr][nc]){
                    if(d%2==0){
                        if(nd == d+1) goNext = true;
                    }else{
                        if(nd == d-1) goNext = true;
                    }
                }
                if(!goNext) continue;

                q.add(new int[]{nr,nc});
                visited[nr][nc] = visited[cr][cc] + 1;
            }
        }
    }
}
