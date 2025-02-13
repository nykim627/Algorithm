import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //OX퀴즈

        int t = sc.nextInt(); //tc 개수

        for(int tc=0;tc<t;tc++){
            String str = sc.next(); //퀴즈 결과 문자열

            int sum = 0; // 총점수
            int subsum = 0; //부분합(연속 O 점수)
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='O'){
                    subsum++;
                }else{
                    subsum = 0; // X 만나면 부분합 초기화
                }
                sum += subsum;
            }//for문 끝
            System.out.println(sum);
        }//tc순회 끝



        sc.close();
    }//main끝
}