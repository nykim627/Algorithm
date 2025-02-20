import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.

		int T = 10; // tc수

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 원본 암호문 뭉치 속 암호문의 개수 N ( 2000 ≤ N ≤ 4000 의 정수)

			// 원본 암호문 뭉치 리스트 생성 및 값 입력
			LinkedList<Integer> origin = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				origin.add(sc.nextInt());
			}

			int m = sc.nextInt(); // 명령어 개수
			// 명령어 순회
			for (int i = 0; i < m; i++) {
				String order = sc.next();
				int x, y, s; //변수 선언
				switch (order) {
				case "I":
					x = sc.nextInt();
					y = sc.nextInt();
					for (int j = 0; j < y; j++) { // 암호문 y번 삽입
						origin.add(x++,sc.nextInt());
					}
					break;
				case "D":
					x = sc.nextInt();
					y = sc.nextInt();
					for(int j=y-1;j>=x;j--) { //뒤에서부터 삭제(인덱스 헷갈릴수 있으므로
						origin.remove(j); 
					}
					break;
				case "A":
					y = sc.nextInt();
					for (int j = 0; j < y; j++) { // 암호문 y번 삽입
						origin.add(sc.nextInt()); //뒤에서 계속 삽입
					}
					break;
				}
			} // 명령어 순회끝
			

			// 결과 출력(암호문 뭉치의 앞 10개 암호문을 출력)
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(origin.get(i) + " ");
			}
			System.out.println();
		} // tc순회 끝
	}
}