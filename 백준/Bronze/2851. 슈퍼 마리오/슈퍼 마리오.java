import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //슈퍼마리오

        int n = 10;  //버섯개수
        int[] arr = new int[10]; //점수 저장 배열

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();    //점수 채우기
        }

        int max = 0; //최대점수합
        int maxIdx = -1; //

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i]; //점수합 계속 갱신
            if(sum<=100){
                max = sum; //최대점수합도 계속 갱신하다가 점수합 100넘으면 갱신 멈추므로 그때의 점수합이 100이하의 최대점수합
                maxIdx = i; //점수합 최대이면서 100보다 작거나 같을 때 가장 큰 인덱스
            }else{
                break; //점수합이 100넘으면 반복문 멈춤.
            }
        }

        //100보다 큰, 가장 작은 점수합과 100의 차가 max와 100의 차와 "같거나 더 작다면" 최대점수합 갱신!!!
        //단, maxIdx가 9인 경우 제외 (인덱스 초과 추의)
        if(maxIdx<9 && ((max+arr[maxIdx+1])-100 <= 100-max)){
            max += arr[maxIdx+1];
        }

        //결과 출력
        System.out.println(max);

        sc.close();
    }//main끝
}