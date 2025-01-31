import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문제 1546 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  //과목 개수 n
        int[] arr = new int[n];  //개별 점수 저장하는 배열
        int max = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();  //개별 점수
            if(arr[i]>max){
                max = arr[i];
            }
        }

        double[] arr2 = new double[n];  //새로운 점수 저장하는 배열
        double sum = 0;
        for(int i=0;i<n;i++){
            arr2[i] = (double) arr[i]/max * 100;
            sum+=arr2[i];
        }
        System.out.println(sum/n);
    }
}
