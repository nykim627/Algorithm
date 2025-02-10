import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 최빈값 찾기
		Scanner sc = new Scanner(System.in);

		int T = 10; // tc수

		for (int tc = 1; tc <= T; tc++) {

			int dumpTime = sc.nextInt(); // 덤프 횟수 (1이상 1000이하)

			int[] arr = new int[100]; // 상자 높이 배열 (가로길이는 항상 100)

			int max=0, min=100;
			int maxIdx = -1;
			int minIdx = -1;
			int diff=0;
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt(); // 배열값 입력
			}
			
			for(int dt=1;dt<=dumpTime;dt++) {	
				for (int i = 0; i < arr.length; i++) {
					if(max<arr[i]) { //최댓값 찾기
						max = arr[i]; maxIdx = i;
					}
					else if(min>arr[i]) { //최솟값 찾기
						min = arr[i]; minIdx=i;
					}
				}
				
				arr[maxIdx]-=1; max=0; //최댓값 갱신 필요
				arr[minIdx]+=1; min=100; //최솟값 갱신 필요
				
				for (int i = 0; i < arr.length; i++) {
					if(max<arr[i]) { //최댓값 다시 찾기
						max = arr[i]; maxIdx = i;
					}
					else if(min>arr[i]) { //최솟값 다시 찾기
						min = arr[i]; minIdx=i;
					}
				}
				diff = arr[maxIdx]-arr[minIdx]; //다시 찾은 최고점과 최저점의 높이 차
			}//dt for문 끝
			
			System.out.println("#" + tc + " " + diff); //결과 출력
		}//tc for문 끝
		sc.close(); //스캐너 닫기
	}//main끝
}
