import java.util.Scanner;

//1. N 은 5 이상 15 이하이다.
//2. M은 2 이상 N 이하이다.
//3. 각 영역의 파리 갯수는 30 이하 이다.

//        7 5
//        17 24 11 29 18 21 11
//        8 5 14 0 19 15 17
//        18 25 29 1 29 16 16
//        3 26 27 20 6 2 27
//        20 13 19 8 13 29 15
//        8 22 8 23 21 7 6
//        14 9 9 27 16 23 29
//        8 6
//        5 27 4 27 24 9 17 27
//        22 3 2 17 23 15 16 20
//        27 27 24 27 9 15 29 26
//        9 8 4 3 8 15 28 28
//        27 25 24 7 16 29 20 20
//        17 6 22 14 2 14 8 27
//        19 13 6 4 11 10 6 10
//        14 12 13 4 8 2 25 4


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int tc=1;tc<=t;tc++) {
            int n = sc.nextInt(); //배열크기 (5이상 15이하)
            int m = sc.nextInt(); //파리채크기 (2이상 n이하)

            int[][] arr = new int[n][n];

            //반복문 순회하면서 배열값 채우기 (파리개수 - 0이상 30이하)
            for(int r=0;r<n;r++) {
                for(int c=0;c<n;c++) {
                    arr[r][c] = sc.nextInt();
                }
            }

            int max = 0;
            for(int r=0;r<=n-m;r++) {
                for(int c=0;c<=n-m;c++) {
                    int sum = 0;
                    for(int i=r;i<r+m;i++) {
                        for(int j=c;j<c+m;j++) {
                            sum+=arr[i][j];
                        }
                    }
                    if(max<sum) {
                        max = sum;
                    }
                }
            }

            System.out.println("#"+tc+" "+max);
        }


    }
}