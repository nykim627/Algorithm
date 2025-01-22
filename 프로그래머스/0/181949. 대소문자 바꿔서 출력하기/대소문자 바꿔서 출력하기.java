import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String output = "";
        
        for (int i=0;i<input.length();i++){
            int tmp = input.charAt(i);
            if(tmp>=97&&tmp<=122){ // 소문자인 경우
                output += (char)(tmp-32); // 32 빼서 대응하는 대문자로
            }else if(tmp>=65&&tmp<=90){ // 대문자인 경우
                output += (char)(tmp+32); // 32 더해서 대응하는 소문자로
            }else{ // 그 외의 경우
                output += (char)tmp; // 그대로 출력
            }
        }
        System.out.println(output);
    }
}