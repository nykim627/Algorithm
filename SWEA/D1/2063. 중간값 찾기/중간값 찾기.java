import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//중간값 찾기
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //N은 항상 홀수(9<=N<=199)
		int[] arr = new int[N]; //정수 배열
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt(); //배열값 입력
		}
		
		Arrays.sort(arr);
		System.out.println(arr[(0+N)/2]); // N은 홀수이므로 (0+N)/2가 중간값의 인덱스
	}
}
