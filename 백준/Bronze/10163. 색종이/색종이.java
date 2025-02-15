import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //색종이(10163)
        //주의할 점: y좌표가 아래에서 위로 증가. 위에서 아래로 증가하는 yprime 좌표 만들기(yprime = 1001-y-1 = 1000-y)
            //근데 상괍없을 것 같음... x축 기준으로 뒤집어서 4사분면에서 색종이 겹치기가 일어난다고 생각하자
            //이러면 왼쪽 아래 점의 좌표가 왼쪽 위의 점의 좌표가 되고, len 증가 방향도 위->아래로 바뀜
        //주의할 점: 좌표평면에서는 x가 열, y가 행

        int t = sc.nextInt(); //색종이 개수

        int[][] arr = new int[1001][1001]; //1001x1001의 격자모양 평면(기본값 0)
        int[][] paperArr = new int[t][4]; //색종이 정보 저장 배열

        for(int tc=0;tc<t;tc++){ //색종이 겹치기
            int x1 = sc.nextInt(); //왼쪽 아래 칸 x 번호
            int y1 = sc.nextInt(); //왼쪽 아래 칸 y 번호
            int width = sc.nextInt(); //너비
            int len = sc.nextInt(); //높이

            paperArr[tc][0] = x1;
            paperArr[tc][1] = y1;
            paperArr[tc][2] = width;
            paperArr[tc][3] = len;

            for(int i=y1;i<y1+len;i++){ //행
                for(int j=x1;j<x1+width;j++){ //열
                    arr[i][j]++; //색종이가 덮힐때마다 해당 칸에 +1 (ex. 3번 겹치는 경우 해당 칸의 값은 3)
                }
            }
        }//색종이 겹치기 끝

        for(int tc=0;tc<t;tc++){
            int x1 = paperArr[tc][0]; //왼쪽 위의 칸 x(열) 번호 (4사분면)
            int y1 = paperArr[tc][1]; //왼쪽 위의 칸 y(행) 번호 (4사분면)
            int width = paperArr[tc][2]; //너비
            int len = paperArr[tc][3]; //높이

            int cnt = 0;

            for(int i=y1;i<y1+len;i++){ //행
                for(int j=x1;j<x1+width;j++){ //열
                    if(arr[i][j]>=1){
                        if(arr[i][j]==1){ //색종이가 1인 칸이 해당 색종이가 보이는 넓이
                            cnt++;
                        }
                        arr[i][j]--; //색종이에 숫자 있을때마다 해당 칸에 -1 (ex. 3번 겹치는 경우 해당 칸의 값은 3)

                    }
                }
            }

            System.out.println(cnt);
        }

        sc.close();
    }//main끝
}