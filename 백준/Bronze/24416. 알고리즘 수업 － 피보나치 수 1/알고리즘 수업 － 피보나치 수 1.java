//package Week3.nayoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//B24416 알고리즘 수업 - 피보나치 수 1
//메모리
public class Main {
    static int cntFib = 0;
    static int cntFibDP = 0;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        fib(n); fibDP(n);

        System.out.println(cntFib+" "+cntFibDP);

        br.close();
    }//main

    static int fib(int n){
        if(n==1 || n==2){
            cntFib++;
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }//fib(dp x)

    static int fibDP(int n){
        memo[1] = memo[2] = 1;
        for(int i=3;i<=n;i++){
            cntFibDP++;
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[n];
    }//fibDP
}
