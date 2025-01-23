import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        while(true){
            int max = 0;
            int idx = 0;
            for(int i=0;i<3;i++){
                arr[i] = sc.nextInt();
                if(max<arr[i]){
                    max = arr[i];
                    idx = i;
                }
            }

            if(max==0){
                break;
            }else{
                int a3 = max*max;
                int a1_a2 = 0;
                arr[idx]=0;
                for(int i=0;i<3;i++){
                    a1_a2 += arr[i]*arr[i];
                }
                if(a3==a1_a2){
                    System.out.println("right");
                }else{
                    System.out.println("wrong");
                }
            }
        }
    }
}