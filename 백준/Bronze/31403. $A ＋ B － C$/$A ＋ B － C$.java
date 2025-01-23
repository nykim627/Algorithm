import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(a+b-c);
		
		String stra = Integer.toString(a);
		String strb = Integer.toString(b);
		String strc = Integer.toString(c);
		
		System.out.println(Integer.parseInt(stra+strb)-Integer.parseInt(strc));
		
		
	}

}
