import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    static int N, M, K;
    static int[] dr = {0,-1,1,0,0};
    static int[] dc = {0,0,0,-1,1};

    static class Bug implements Comparable<Bug>{
        int r, c, val;

        public Bug(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Bug o) {
            return o.val-this.val;
        }

        @Override
        public String toString() {
            return "Bug{" +
                    "r=" + r +
                    ", c=" + c +
                    ", val=" + val +
                    '}';
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
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //구역 크기(5~100)
            M = Integer.parseInt(st.nextToken()); //격리시간(1~1000)
            K = Integer.parseInt(st.nextToken()); //미생물 군집 개수(5~1000)
            int[][] dir = new int[N][N];
            int[][] num = new int[N][N];
            PriorityQueue<Bug> pq = new PriorityQueue<>();
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); //세로위치
                int b = Integer.parseInt(st.nextToken()); //가로위치
                int val = Integer.parseInt(st.nextToken()); //미생물 수(1~10000)
                int onedir = Integer.parseInt(st.nextToken()); //이동방향
                pq.add(new Bug(a,b,val));
                dir[a][b] = onedir;
                num[a][b] = val;
            }//입력 끝

            int[][] nextdir;
            int[][] nextnum;
            PriorityQueue<Bug> nextpq = new PriorityQueue<>();
            for(int m=1;m<=M;m++){
                nextdir = new int[N][N];
                nextnum = new int[N][N];
                while(!pq.isEmpty()){
                    Bug bug = pq.poll();
//                    System.out.println(bug.toString());
                    int r = bug.r;
                    int c = bug.c;
                    if(dir[r][c]==0) continue; //군집 없는 칸은 패스
                    int nr = r + dr[dir[r][c]];
                    int nc = c + dc[dir[r][c]];
                    if(nr==0||nc==0||nr==N-1||nc==N-1){
                        nextdir[nr][nc] = dir[r][c]%2==1 ? dir[r][c]+1 : dir[r][c]-1;
                        nextnum[nr][nc] = num[r][c]/2;
                        if(nextnum[nr][nc]==0) nextdir[nr][nc]=0; //군집사라짐
                    }else{
                        if(nextnum[nr][nc] < num[r][c]) nextdir[nr][nc] = dir[r][c]; //군집 없는 칸에 군집 오거나, 있는 칸에 더 많은 군집 와서 방향 바뀌거나
                        nextnum[nr][nc] += num[r][c];
                    }
                }
                num = deepCopy(num, nextnum);
                dir = deepCopy(dir, nextdir);
                for(int r=0;r<N;r++){
                    for(int c=0;c<N;c++){
                        pq.add(new Bug(r,c,num[r][c]));
                    }
                }
            }//격리시간 m시간 끝

            int ans = 0;
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    ans += num[r][c];
                }
            }
            sb.append(ans).append("\n");

        }//tc끝

        System.out.println(sb.toString());

    }//main

    static int[][] deepCopy(int[][] arr1, int[][] arr2){
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                arr1[r][c] = arr2[r][c];
            }
        }
        return arr1;
    }

}
