import java.util.*;
import java.io.*;

//DP문제!!
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];
        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0) dp[i][j]=dp[i-1][0]+arr[i][j];
                else if(j==N-1) dp[i][j]=dp[i-1][i-1]+arr[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
            }
        }
        
        int res = 0;
        for(int i=0;i<N;i++){
            res = Math.max(dp[N-1][i],res); //맨 밑줄 수 중 최댓값
        }
        
        System.out.println(res);
    }
}