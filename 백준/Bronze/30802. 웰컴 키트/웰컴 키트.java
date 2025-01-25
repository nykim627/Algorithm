import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] arr = new int[6];
        for(int i=0;i<6;i++){
            arr[i] = sc.nextInt();
        }

        int[] arr2 = new int[2];
        for(int i=0;i<2;i++){
            arr2[i] = sc.nextInt();
        }

        int m = 0;
        for(int i=0;i<6;i++){
            if(arr[i]%arr2[0]==0){
                m+=arr[i]/arr2[0];
            }else{
                m+=(arr[i]/arr2[0]+1);
            }
        }

        int n = a/arr2[1];
        int k = a%arr2[1];

        System.out.println(m);
        System.out.printf("%d %d",n, k);


    }
}