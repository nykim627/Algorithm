import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0; //생성자가 없는 경우 0 출력

        for(int i=1;i<=n;i++){
            int sum = 0; //자리수 합 저장하기
            int tmp = i;
            while(tmp!=0){
                sum += tmp%10; // 각 자리수 더하기
                tmp = tmp/10;
            }
            // 가장 작은 생성자를 찾은 경우
            if(i+sum==n){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}