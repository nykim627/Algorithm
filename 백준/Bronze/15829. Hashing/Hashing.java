import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int l = sc.nextInt();
        String str = sc.next();
        int sum = 0;
        for(int i=0;i<l;i++) {
        	sum += ((str.charAt(i)-96)*square(31,i));
        }
        
        int m = 1234567891;
        int h = sum%m;
        
		System.out.println(h);
		sc.close();
	}
	
	public static int square(int r, int i) {
		int mul = 1;
		for(int j=1;j<=i;j++) {
			mul *= r;
		}
		return mul;
	}

}
