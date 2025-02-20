import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.

		int T = sc.nextInt(); // tc수

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 농장의 크기 n (1<=n<=49)

			// 농작물 가치 입력
			String[][] arr = new String[n][n];
			for (int r = 0; r < n; r++) {
				arr[r] = sc.next().split("");
			}

			// 수익 구하기
			int sum = 0;
			for (int r = 0; r < n/2; r++) { //중앙행 빼고 모두 더함
				for(int i=n/2-r;i<=n/2+r;i++) {
					sum += Integer.parseInt(arr[r][i]);
				}
				for(int i=n/2-r;i<=n/2+r;i++) {
					sum += Integer.parseInt(arr[n-1-r][i]);
				}
			}
			for(int i=0;i<n;i++) { //중앙행 모두 더함
				sum += Integer.parseInt(arr[n/2][i]);
			}

			// 결과 출력
			System.out.println("#" + tc + " " + sum);
		} // tc순회 끝
	}
}