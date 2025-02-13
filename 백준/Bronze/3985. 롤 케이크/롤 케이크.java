import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //롤케이크

        int L = sc.nextInt(); //롤케이크 길이
        int[] arr = new int[L+1]; //0~N번 롤케잌 칸 (0번은 무시)
        int N = sc.nextInt(); //방청객 수

        int wishMax = 0; //기대 최대값
        int wishMaxIdx = -1; //기대 최대값을 갖는 방청객 번호

        int currMax = 0; //실제 최대값
        int currMaxIdx = -1; //실제 최대값을 갖는 방청객 번호

        for(int i=1;i<=N;i++){ //방청객 번호
            int p = sc.nextInt();
            int k = sc.nextInt();

            if(wishMax < k-p){
                wishMax = k-p;
                wishMaxIdx = i;
            }

            int cnt = 0;
            for(int j=p;j<=k;j++){
                if(arr[j]==0) { //아직 롤케이크에 번호가 채워지지 않았다면
                    arr[j] = i; //해당 롤케이크 칸에 방청객 번호 채우기
                    cnt++;
                }
            }

            if(currMax<cnt){
                currMax = cnt;
                currMaxIdx = i;
            }

        }

        //결과 출력
        System.out.println(wishMaxIdx); //기대 최대값을 갖는 방청객 번호
        System.out.println(currMaxIdx); //실제 최대값을 갖는 방청객 번호


        sc.close();
    }//main끝
}