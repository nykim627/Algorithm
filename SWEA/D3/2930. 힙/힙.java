import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc수

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 수행해야하는 연산의 수(1<=n<=10^5)
			sc.nextLine();
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			System.out.print("#" + tc+ " ");
			
			for (int i = 0; i < n; i++) { // 연산 정보 입력
				String[] order = sc.nextLine().split(" ");
				if (order[0].equals("1")) { // 연산1
					int num = Integer.parseInt(order[1]);
					pq.add(-num); // 최대힙 구현 위해 음수로 변환
				} else if(order[0].equals("2")) { // 연산2
					if (pq.isEmpty()) {
						System.out.print(-1 + " ");
					} else {
						System.out.print(-pq.poll() + " ");
					}
				}
			}
			
			System.out.println();

			// 결과 출력
//			System.out.println("#" + tc + " " + sum);
		} // tc순회 끝
	}
}