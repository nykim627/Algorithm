import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String my_string = sc.next();

        int[] answer = new int[26];
        Arrays.fill(answer, -1); // 기본값 -1로 초기화

        for (int j = 0; j < my_string.length(); j++) {
            char ch = my_string.charAt(j);
            int index = ch - 'a'; // 'a'의 ASCII 값(97)부터 0~25로 변환

            if (answer[index] == -1) { // 첫 등장 위치만 저장
                answer[index] = j;
            }
        }
        //System.out.println(Arrays.toString(answer));

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
    }
}