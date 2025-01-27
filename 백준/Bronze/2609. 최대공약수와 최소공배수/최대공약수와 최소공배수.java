import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // 최대공약수(GCD; Greatest Common Divisor)
        // 유클리드 호제법: 이전에 나누는 수(n)와 나머지(m)가 새롭게 나눠지는 수(n)와 나누는 수(m)가 된다.
        // m==0일 때의 n(나누는값)이 최대공약수이다.
        int n = a;
        int m = b;
        while(m!=0){
            int tmp = m;
            m = n%m;
            n = tmp;  //최ㅐ공약수
        }
        int gcd = n;

        // 최소공배수(LCM; Least Common Multiple)
        // 최소공배수는 두 값 a, b를 곱한 값에서 최대공약수를 나눈 값! 즉, a*b/n이다.
        int lcm = a*b/gcd;

        System.out.println(gcd);
        System.out.println(lcm);

    }
}