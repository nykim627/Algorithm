import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        BigInteger biga = new BigInteger(a);
        BigInteger bigb = new BigInteger(b);


        System.out.println(biga.add(bigb));
        System.out.println(biga.subtract(bigb));
        System.out.println(biga.multiply(bigb));


    }
}