import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int l = sc.nextInt();
        String str = sc.next();
        long sum = 0;
        long m = 1234567891;
        int r = 31;
        
        for (int i = 0; i < l; i++) {
            long value = (str.charAt(i) - 'a' + 1);
            sum = (sum + (value * modPow(r, i, m)) % m) % m;  // 모듈러 연산 적용
        }

        System.out.println(sum);
        sc.close();
    }

    // 빠른 거듭제곱 (Exponentiation by Squaring)
    public static long modPow(long base, int exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {  // 홀수이면 base를 한 번 곱함
                result = (result * base) % mod;
            }
            base = (base * base) % mod;  // base를 제곱하여 지수를 줄임
            exp /= 2;
        }
        return result;
    }
}
