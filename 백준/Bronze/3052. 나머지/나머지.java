import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //나머지

        int[] count = new int[42]; //0~41까지의 나머지를 저장하는 카운팅 배열

        for(int i=0;i<10;i++){
            int n = sc.nextInt();
            count[n%42]++;
        }

        int cnt = 0; //서로 다른 나머지가 몇개 있는지
        for(int i=0;i<42;i++){
            if (count[i] != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);

        sc.close();
    }//main끝
}