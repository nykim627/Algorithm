import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //컵홀더 : *S*LL*LL*S*S*LL*에서 '*'의 개수 구하기

        int n = sc.nextInt();  //좌석개수
        String str = sc.next(); //좌석정보나열된 문자열

        int cnt=1; // '*'의 개수 (맨 왼쪽에 컵홀더 있는 상태로 시작)

        for(int i=0;i<str.length();i++){
            if( str.charAt(i)=='S'){
                cnt++; // 좌석이 'S'면 바로 오른쪽에 컵홀더 넣기
            }else if(str.charAt(i)=='L'){
                i+=1; //좌석 하나 건너뛰고 (L은 항상 두개씩 쌍으로 주어지므로 가능!)
                cnt++; //컵홀더 넣기
            }
        }
        //결과 출력
        if(n<cnt){ //컵홀더 개수보다 사람이 적은 경우는 사람 수 출력
            System.out.println(n);
        }else{
            System.out.println(cnt);
        }
        sc.close();
    }//main끝
}