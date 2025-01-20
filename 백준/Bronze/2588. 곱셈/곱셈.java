import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int s3 = b%10;
        int s2 = (b%100-b%5)/10;
        int s1 = (b-b%100)/100;
        System.out.println(a*s3);
        System.out.println(a*s2);
        System.out.println(a*s1);
        System.out.println(a*s3+a*s2*10+a*s1*100);
    }
}