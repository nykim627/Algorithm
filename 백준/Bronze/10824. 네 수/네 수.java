

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        // 1 ≤ A, B, C, D ≤ 1,000,000
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        String d = sc.next();

        long ab = Long.parseLong(a+b); //최대 14자리이므로 int 범위(최대10자리) 초과 -> long (최대 19자리)
        long cd = Long.parseLong(c+d);

        System.out.println(ab+cd);
        
    }
}
