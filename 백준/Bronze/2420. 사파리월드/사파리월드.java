import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        if(n-m<0){
            System.out.println(m-n);
        }else{
            System.out.println(n-m);
        }
    }
}