import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 기본 아이디어: 0값으로 이루어진 100x100 카운팅 배열에서 검정 색종이가 올라간 칸에 1을 더하면서 마지막에 배열값이 0이 아닌 칸의 개수를 출력한다.
        // x = 0~1, y = 0~1 사이의 칸을 0번째 칸이라고 하자.
        int[][] arr = new int[100][100]; //기본값 0인 배열

        int t = sc.nextInt(); //색종이 개수


        int cnt = 0; //색칠된 칸의 개수

        for(int tc=0;tc<t;tc++){

            int x = sc.nextInt(); // 열 인덱스
            int y = sc.nextInt(); // 행 인덱스

            for(int r=y; r<y+10; r++){
                for(int c=x; c<x+10; c++){
                    arr[r][c]++;
                }
            }
        }//tc순회끝

        // 색칠된 칸의 개수 찾기
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j]>0){
                    cnt++;
                }
            }
        }

        //결과 출력
        System.out.println(cnt);



        sc.close();
    }//main끝
}