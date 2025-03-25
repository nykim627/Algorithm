import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int minSum; //최소비용
    static int[] mon = new int[13]; //월별 이용계획(1월~12월)
    static int[] pick = new int[4]; //4가지 이용권의 요금
    static int sum = 0; //dfs 내의 subsum

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++){
                pick[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=12;i++){
                mon[i] = Integer.parseInt(st.nextToken());
            }

            minSum = pick[3]; //1년이용권 비용을 최소비용으로 초기화(아래 함수에서는 1년이용권 생각하지 않음)
            dfs(1,0); //1월부터 dfs
            System.out.println("#"+tc+" "+minSum);
        }//tc순회
    }//main

    static void dfs(int depth, int sum){
        if(depth>12){
            if(minSum>sum) minSum = sum;
            return;
        }
        for(int i=0;i<3;i++){ //1일, 1달, 3달만 고려
            if(i==0){
                dfs(depth+1, sum + mon[depth]*pick[0]);
            }else if(i==1){
                dfs(depth+1, sum + pick[1]);
            }else {
                dfs(depth+3, sum + pick[2]);
            }
        }
    }
}
