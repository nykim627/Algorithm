import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 10; //tc 개수

        for(int tc=1;tc<=t;tc++){ //tc반복

            int n = sc.nextInt(); //원본 암호문의 길이
            //원본 암호문 입력
            LinkedList<String> origin = new LinkedList<>();
            for(int i=0;i<n;i++){
                origin.add(sc.next());
            }

            int m = sc.nextInt(); //명령어의 개수
            for(int i=0;i<m;i++){ //명령어 개수만큼 반복
                String insert = sc.next(); //항상 I 입력
                int x = sc.nextInt(); //삽입할 위치(인덱스)
                int y = sc.nextInt(); //삽입할 숫자 개수
                for(int j=0;j<y;j++){ //명령어 한번에 삽입할 숫자 계속 입력
                    origin.add(x++,sc.next());
                }

            }//명령어반복 끝

            //결과 출력
            System.out.print("#"+tc);
            for(int i=0;i<10;i++){
                System.out.print(" "+origin.get(i));
            }
            System.out.println();
        }//tc순회끝

        sc.close();
    }//main끝


}