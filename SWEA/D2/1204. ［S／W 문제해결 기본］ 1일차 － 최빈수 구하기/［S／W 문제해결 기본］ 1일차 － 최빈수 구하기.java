import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 최빈값 찾기
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc수

		for (int tc = 0; tc < T; tc++) {

			int tcNum = sc.nextInt(); // tc 번호

			int[] arr = new int[1000]; // 학생 점수 배열
			int[] count = new int[101]; // 0~100의 수에 대한 카운팅배열

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt(); // 배열값 입력
				count[arr[i]]++;
			}

			// 카운팅 배열의 최댓값 찾기
			int countMax = 0; // 카운팅배열의 최댓값
			int mode = -1; // 카운팅배열의 최댓값의 인덱스가 최빈값
			for (int i = 0; i < count.length; i++) {
				if (countMax <= count[i]) { // 최빈수가 여러개일때도 포함하기 위해 '=' 넣어줌
					countMax = count[i]; // 얘 없으면 최댓값 업데이트가 안돼서 반복문이 제대로 안돌아감.
					mode = i; // 최빈수가 여러 개일때에는 가장 큰 점수를 출력(카운팅배열 인덱스에 의해 자동으로 큰점수로 업데이트)
				}
			}
			System.out.println("#" + tcNum + " " + mode);
		}
	}
}
