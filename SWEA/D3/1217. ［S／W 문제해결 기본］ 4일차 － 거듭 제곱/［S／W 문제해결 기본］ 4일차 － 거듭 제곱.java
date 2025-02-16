import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 10; //tc 개수

        for(int tc=1;tc<=t;tc++){ //tc반복
            int tcNum = sc.nextInt();

            int n = sc.nextInt();
            int m = sc.nextInt();

            //결과 출력
            int ans = power(n,m); //결과 값은 Integer 범위를 넘어가지 않는다.
            System.out.println("#"+tcNum+" "+ans);
        }//tc순회끝

        sc.close();
    }//main끝

    static int power(int n,int m){
        if(m==0){ //기본부분
            return 1;
        }
        else{
            return power(n,m-1) * n; //재귀부분
        }
    }


}