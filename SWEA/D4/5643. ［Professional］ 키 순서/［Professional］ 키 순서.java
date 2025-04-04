import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){
            sb.append("#").append(tc).append(" ");

            //입력받기 시작
            int N = Integer.parseInt(br.readLine()); //학생수(2~500)
            int[][] dist = new int[N+1][N+1];
            for(int i=0;i<=N;i++){
                for(int j=0;j<=N;j++){
                    dist[i][j] = INF;
                }
            }

            int M = Integer.parseInt(br.readLine()); //비교횟수
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                dist[a][b]++; //a학생이 b학생보다 키가 작다(유향그래프)
            }//입력완료

            for(int k=1;k<=N;k++){
                for(int i=1;i<=N;i++){
                    if(dist[i][k]==INF) continue;
                    for(int j=1;j<=N;j++){
                        if(dist[k][j]==INF) continue;
                        dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }

            int totalCnt = 0;
            for(int k=1;k<=N;k++){
                int cnt = 0;
                for(int i=1;i<=N;i++){
                    if(dist[i][k]!=INF) cnt++;
                    if(dist[k][i]!=INF) cnt++;
                }
                if(cnt==N-1) totalCnt++;
            }


            sb.append(totalCnt).append("\n");

        }//tc끝

        System.out.println(sb.toString());

    }//main
}
