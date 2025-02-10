import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// Flatten
		Scanner sc = new Scanner(System.in);

		int T = 10; // tc수

		for (int tc = 1; tc <= T; tc++) {

			int dumpTime = sc.nextInt(); // 덤프 횟수 (1이상 1000이하)
			int[] arr = new int[100]; // 상자 높이 배열 (가로 길이는 항상 100)

            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt(); // 배열값 입력
            }
			
			//처음부터 각 높이별 상자 개수를 기록해둔다.
			int[] count = new int[101]; //1~100 높이 개수 저장
			
			//각 높이를 갖는 가로칸의 개수를 세서 카운팅 배열에 저장
			for(int h: arr) {
				count[h]++;
			}
			
			
			//최고점(start)과 최저점(end) 위치를 따로 추적하며 평탄화 진행(O(dump))
			int start=1, end=100; 
			
			while(dumpTime>0&&start<end) {
				//최저점 찾기(현재 높이에 상자가 없으면 다음 높이로)
				while(count[start]==0) start++;
				//최고점 찾기
				while(count[end]==0) end--;
				
				//평탄화 수행
				count[start]--; //최저점에서 하나 빼기(가장 낮은 상자 높이를 갖는 칸이 하나 줄어듦)
				count[start+1]++; //최저점+1에 추가
				count[end]--; //최고점에서 하나 빼기
				count[end-1]++; //최고점-1에 추가
				dumpTime--; //덤프 횟수 감소
			}//dumpTime while문 끝
			
			while(count[start]==0) start++;
			while(count[end]==0) end--;
			
			System.out.println("#" + tc + " " + (end-start)); //결과 출력
		}//tc for문 끝
		sc.close(); //스캐너 닫기
	}//main끝
}
