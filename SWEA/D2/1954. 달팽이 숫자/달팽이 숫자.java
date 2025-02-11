import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1부터 N^2까지의 숫자가 시계방향으로 이루어져 있는 달팽이

        int t = sc.nextInt(); //테스트케이스 개수

        for(int tc=1;tc<=t;tc++) {

            int n = sc.nextInt(); //nxn 배열
            int[][] arr = new int[n][n]; //nxn배열 (1<=n<=10)

            //달팽이 순회하면서 배열값 채우기
            int largeN  = n*n; //마지막 수: n^2
            int K = n; //한변에서 이동하는 길이
            int dir = 1; //방향
            int num = 1; //배열칸에 채워지면서 +1
            int c = -1; //이동하는 열 인덱스
            int r = 0; //이동하는 행 인덱스
            while(true){ //무한반복
                // 수평 -> 수직
                for(int i=0;i<K;i++){ //수평이동 (행고정(r), 열변함(반복문 도는 동안 c값 변함))
                    c+=dir;
                    arr[r][c] = num++;
                }
                K--; //수평->수직 전환시

                // 중간에 종료조건
                if(K==0) break;

                // 수직 -> 수평
                for(int j=0;j<K;j++){ //수직이동 (행변함(반복문 도는 동안 r값 변함), 열고정(c))
                    r += dir;
                    arr[r][c] = num++;
                }
                dir*=-1; //수직->수평 전환시
            }//무한반복 끝

            System.out.println("#"+tc); // 테스트케이스 번호 출력
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }

        }//tc반복문 끝
    }//main끝

}