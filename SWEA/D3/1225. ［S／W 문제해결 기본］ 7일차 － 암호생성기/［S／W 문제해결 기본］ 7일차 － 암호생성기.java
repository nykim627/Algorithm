import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10; // tc수

		for (int tc = 1; tc <= T; tc++) {

			int tcNum = sc.nextInt(); // tc번호

			Queue<Integer> queue = new LinkedList<>(); // 큐 생성
			// 입력
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}

			while (true) {
				int tmp = queue.poll();
				if (tmp - 1 <= 0) {
					queue.add(0);
					break;
				} else {
					queue.add(tmp - 1);
				}
				
				tmp = queue.poll();
				if (tmp - 2 <= 0) {
					queue.add(0);
					break;
				} else {
					queue.add(tmp - 2);
				}
				
				tmp = queue.poll();
				if (tmp - 3 <= 0) {
					queue.add(0);
					break;
				} else {
					queue.add(tmp - 3);
				}
				
				tmp = queue.poll();
				if (tmp - 4 <= 0) {
					queue.add(0);
					break;
				} else {
					queue.add(tmp - 4);
				}
				
				tmp = queue.poll();
				if (tmp - 5 <= 0) {
					queue.add(0);
					break;
				} else {
					queue.add(tmp - 5);
				}
				
			}

			// 결과출력
			System.out.print("#" + tc + " ");
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();

		} // tc순회끝

	}

}
