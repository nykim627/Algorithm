import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //색종이2
        // 기본 아이디어
        // (1) 0값으로 이루어진 100x100 카운팅 배열에서 검정 색종이가 올라간 칸에 1씩 계속 더한다.
        // (2) 값이 0이 아닌 칸의 상하좌우를 확인하면서 상하좌우가 0이 나오는 개수를 더한다. -> 델타 이용
        //     ex) 모서리는 상하좌우 중 2개가 0값을 갖는 칸과 만남, 모서리 아닌 변은 1개가 0값을 갖는 칸과 만남. 이걸 다 더한게 둘레가 된다.
        // x = 0~1, y = 0~1 사이의 칸을 0번째 칸이라고 하자.
        int[][] arr = new int[100][100]; //기본값 0인 배열

        int t = sc.nextInt(); //색종이 개수


        int cnt = 0; // 0이 아닌 칸과 0칸이 만나는 변의 개수

        for(int tc=0;tc<t;tc++){

            int x = sc.nextInt(); // 열 인덱스
            int y = sc.nextInt(); // 행 인덱스

            // 카운팅 배열에 값채우기
            for(int r=y; r<y+10; r++){
                for(int c=x; c<x+10; c++){
                    arr[r][c]++;
                }
            }
        }//tc순회끝

        // 색칠된 도형의 둘레 찾기
        int[] dr = {-1,1,0,0}; //델타
        int[] dc = {0,0,-1,1};
        for(int r=0; r<100; r++){
            for(int c=0; c<100; c++){
                if(arr[r][c]>0){
                    for(int d=0; d<4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr<0||nc<0||nr>=100||nc>=100){  //인덱스 초과 처리 -> 이때는 하얀 도화지 변에 붙은 경우이므로 둘레맞음
                            cnt++;
                        } else if(arr[nr][nc]==0){
                            cnt++;
                        }
                    }
                }
            }
        }
        //결과 출력
        System.out.println(cnt);
        sc.close();
    }//main끝
}