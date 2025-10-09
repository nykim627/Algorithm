import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        //dp[i] = i일부터 N일까지 얻을 수 있는 최대 수익
        int[] dp = new int[N+2]; //N+1일은 최대 수익 0.
        for(int i=N;i>0;i--){
            if(i+T[i] > N+1) dp[i] = dp[i+1]; //얘 때문에 dp범위 N+2로 설정. 최대 N일에 1일동안 상담 = N+1이므로 이거 초과하면 안되는것.
            else{
                int nonSelect = dp[i+1]; //이날 상담 선택 안하면 그전 dp값
                int select = P[i] + dp[i+T[i]]; //선택하면 i+T[i]일부터 N일까지의 보상 + 이날 보상
                dp[i] = Math.max(nonSelect, select);
            }
        }
        System.out.println(dp[1]);
    }
}