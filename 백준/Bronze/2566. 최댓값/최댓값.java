import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //최대값

        int[][] arr = new int[9][9]; //9x9 배열 (0행, 0열부터 시작)
        int max = 0; //최대값
        int maxcol = 1; //모든 값이 0일 때, maxcol, maxrow 1로 초기화해둬야지 1행1열이 나온다(주어지는 수는 100보다 작은 자연수 또는 0이기 때문)
        int maxrow = 1;
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                arr[r][c] = sc.nextInt();  //배열값 입력

                //입력받으면서 최대값 및 그때의 인덱스 바로바로 갱신
                if(arr[r][c]>max){
                    max = arr[r][c];
                    maxrow = r+1; //0행부터 시작이므로 문제에 맞게 +1해줘야 함
                    maxcol = c+1; //0열부터 시작이므로 문제에 맞게 +1해줘야 함
                }
            }

        }

        System.out.println(max);
        System.out.println(maxrow+" "+maxcol);

        sc.close();
    }//main끝
}