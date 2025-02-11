import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while (true) { // 무한반복
			String str = sc.next(); // 문자열 입력
			if (str.equals("0"))
				break; // (무한반복종료조건) 0 입력받으면 반복문 break;
			else {
				int len = str.length(); // 문자열 길이
				boolean isPal = true; // 팰린드롬수인지 저장하는 변수

				for (int i = 0; i < len / 2; i++) {
					if (str.charAt(i) != str.charAt(len - 1 - i)) {
						isPal = false;
						break;
					}
				}
				if (isPal) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
}
