import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //직사각형을 만드는 방법

        int n = sc.nextInt(); // 정사각형 개수
        int cnt = 0; //만들 수 있는 직사각형 개수

        for(int i=1;i<=n;i++){ //직사각형 넓이 1인 경우부터 n인 경우까지 반복하면서 찾기
            int r = 1;
            int c = n;
            int tmp = 1; //나누는 수. while문 내에서 바뀜.
            while(tmp*tmp<=i){ // r<=c 유지 위해
                if(i%tmp==0){ //나누어떨어지면
                    r = tmp;
                    c = n/tmp;
                    cnt++; //직사각형 종류 +1
                }
                tmp++; //나누어떨어지던 아니던 tmp +1하기
            }
        }//직사각형 넓이 반복 끝
        System.out.println(cnt);

        sc.close();
    }//main끝
}