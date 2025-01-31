import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문제 2609 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // 최대공약수(gcl)
        // 유클리드 호제법을 이용하여 구하기. 기존의 나누는 값(m)과 나머지(n%m)가 새롭게 나눠지는 값(n)과 나누는 값(m)이 된다.
        // 나머지 m=0일 때의 나누는 값(n)이 최대공약수이다.
        int n = a;
        int m = b;
        while(m!=0){
            int tmp = m; //기존의 나누는 값을 임시 변수에 저장해둠 -> 새롭게 나누지는 값(n)이 되야 한다.
            m = n%m;     //기존의 나머지(n%m) -> 새롭게 나누는 값(m)이 되야 한다.
            n = tmp;
        }
        int gcl = n;

        // 최소공배수(lcm)
        // 두 값 a와 b의 곱에서 최대공약수로 나눈 값이 최소공배수이다.
        int lcm = a*b/gcl;

        System.out.println(gcl);
        System.out.println(lcm);


    }
}