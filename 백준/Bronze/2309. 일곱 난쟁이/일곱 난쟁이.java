import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 배열 선언 및 입력받기 (1) - 아홉난쟁이
        int[] arr = new int[9];
        // 배열 입력
        for(int i=0;i<9;i++){
            arr[i] = sc.nextInt();
        }

        // totalsum 구하기
        int totalsum = 0; //아홉명 키의 합
        for(int i=0;i<9;i++){
            totalsum += arr[i];
        }

        // 가짜 두명 찾아내기 (일곱 난쟁이를 찾을 수 없는 경우는 없다.)
        int twosum = 0; //가짜 두명 키의 합
        int idx1 = -1; //가짜 1번 인텍스
        int idx2 = -1; //가짜 2번 인덱스
        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                twosum = arr[i]+arr[j];
                if(totalsum-twosum==100){
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }//여기 break; 가 없어도 됨???
        }

        // 새로운 배열 (진짜 일곱 난쟁이들만 있어!)
        int[] answer = new int[7];
        int idx = 0;
        for(int i=0;i<9;i++){ //arr 전체 돌아야하므로 7이 아니라 9까지!!
            if(i!=idx1 && i!=idx2){
                answer[idx++] = arr[i];
            }
        }
        //System.out.println(Arrays.toString(answer));

        // 버블 정렬
        for(int i=0;i<7;i++){
            for(int j=i+1;j<7;j++){
                if(answer[i]>answer[j]){
                    int tmp = answer[j];
                    answer[j] = answer[i];
                    answer[i] = tmp;
                }
            }
        }

        //새로운 배열 출력
        for(int i=0;i<7;i++){
            System.out.println(answer[i]);
        }
    }//main 끝
}