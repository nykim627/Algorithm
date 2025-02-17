import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //tc 개수

        for(int tc=1;tc<=t;tc++){ //tc반복

            int n = sc.nextInt();
            int m = sc.nextInt();

            //카운팅배열
            int[] cnt = new int[n+m+1]; //0~(n+m)까지의 각 값의 빈도 저장하는 카운팅배열

            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    cnt[i+j]++;
                }
            }

            int max = 0; //최대합
            for(int i=0;i<cnt.length;i++){
                if(max<cnt[i]){
                    max = cnt[i];
                }
            }

            //결과 출력
            System.out.print("#"+tc);
            for(int i=0;i<cnt.length;i++){
                if(max==cnt[i]){
                    System.out.print(" "+i);
                }
            }
            System.out.println();
        }//tc순회끝

        sc.close();
    }//main끝


}