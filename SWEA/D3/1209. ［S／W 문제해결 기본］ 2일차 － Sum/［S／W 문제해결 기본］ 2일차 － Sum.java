import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 10;

        for(int tc=1;tc<=t;tc++) {
            int tcNum = sc.nextInt(); //tc 번호

            int[][] arr = new int[100][100]; //100x100배열 (각 행의 합은 Integer범위를 벗어나지 않음)

            //반복문 순회하면서 배열값 채우기
            for(int r=0;r<100;r++) {
                for(int c=0;c<100;c++) {
                    arr[r][c] = sc.nextInt();
                }
            }

            //행 합의 최댓값 구하기
            int rowMax = 0;
            for(int r=0;r<100;r++){
                int rowSum = 0;
                for(int c=0;c<100;c++){
                    rowSum+=arr[r][c];
                }
                if(rowMax<rowSum){
                    rowMax = rowSum;
                }
            }

            //열 합의 최댓값 구하기
            int colMax = 0;
            for(int c=0;c<100;c++){
                int colSum = 0;
                for(int r=0;r<100;r++){
                    colSum+=arr[r][c];
                }
                if(colMax<colSum){
                    colMax = colSum;
                }
            }

            //대각선합의 최댓값 구하기
            int diagSum1 = 0;
            int diagSum2 = 0;
            for(int r=0;r<100;r++){
                diagSum1 += arr[r][r];
                diagSum2 += arr[r][100-r-1];
            }
            int diagMax = Math.max(diagSum1, diagSum2); // 두 대각선합 중 최댓값


            int totalMax = Math.max(Math.max(rowMax,colMax),diagMax); // 최종 최댓값 구하기

            System.out.println("#"+tcNum+" "+totalMax);
        }

    }
}