import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //크로아티아 알파벳

        String str = sc.next();
        String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="}; //특수 크로아티아 알파벳 배열

        for(String e: arr){
            if(str.contains(e)) {
                //특수 크아 알파벳이면 *로 대체(대체문자는 어떤것이든 상관없음)
                str = str.replace(e, "*"); //결과를 str에 업데이트해줘야함
            }
        }

        //결과 출력
        System.out.println(str.length());

        sc.close();
    }//main끝
}