import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			String str = sc.next();
			int isOK = 1;

			char[] arr = str.toCharArray();

			for (int i = 0; i < arr.length / 2; i++) {
				if (arr[i] != arr[arr.length - 1 - i]) {
					isOK = 0;
					break;
				}
			} 
			System.out.println("#" + tc + " " + isOK);
		}// tc끝
	}
}
