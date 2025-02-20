import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.

		int T = sc.nextInt(); // tc수

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 숫자열 길이 n

			LinkedList<Integer> list = new LinkedList<>();

			// 값 입력
			for (int i = 0; i < n; i++) {
            	list.add(sc.nextInt());
			}

			// 선택 정렬
			for (int i = 1; i < n; i++) { // 정렬하고 싶은 값(key) 순회
				int j; //정렬 포인트
            	int key = list.get(i);
            	for( j=i-1;j>=0&&key<list.get(j);j--) {
            		list.add(j+1,list.get(j)); //j+1번째에 값 추가했으므로
            		list.remove(j+2); //기존의 j+1번째 값이 그 다음으로 밀림. 이걸 삭제하기.
            	}
            	list.add(j+1,key);
            	list.remove(j+2);
			}

			// 결과 출력
			System.out.print("#" + tc + " ");
			for(int i=0;i<n;i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		} // tc순회 끝
	}
}
