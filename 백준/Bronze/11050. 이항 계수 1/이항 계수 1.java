import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int sum_n=1;
        int sum_k=1;
        int sum_n_k=1;

        for(int i=1;i<=k;i++){
            sum_k*=i;
        }
        for(int i=1;i<=n;i++){
            sum_n*=i;
        }
        for(int i=1;i<=n-k;i++){
            sum_n_k*=i;
        }

        int total = sum_n/sum_k;
        int total2 = total/sum_n_k;

        System.out.println(total2);
    }
}