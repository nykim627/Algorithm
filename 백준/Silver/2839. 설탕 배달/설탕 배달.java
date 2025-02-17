import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 킬로그램 수

		int cntFive = n / 5;
		int cntThree = 0;
		boolean isOk = false;
		while (cntFive != -1) {
			if ((n - cntFive * 5) % 3 != 0) {
				cntFive--;
			} else {
				cntThree = (n - cntFive * 5) / 3;
				isOk = true;
				break;
			}
		}
		
		if(isOk) {
			System.out.println(cntFive+cntThree);
		}else {
			System.out.println(-1);
		}
	}

}