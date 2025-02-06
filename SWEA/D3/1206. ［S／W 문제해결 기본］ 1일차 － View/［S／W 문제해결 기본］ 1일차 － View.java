import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//tc 순회 (총 10개)
		for(int tc=1;tc<=10;tc++) {
			int N = sc.nextInt(); //건물 개수
			
			int[] arr = new int[N]; //N개 건물의 높이 저장하는 배열 생성

			//배열순회하며 값 입력
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			
			int sum = 0; // 조망권 확보 총 세대수
			for(int i=2;i<N-2;i++) {
				int minsub = 255; //최소 건물높이 차 선언 및 초기화(최대건물높이)
				int sub1 = arr[i]-arr[i-2];
				int sub2 = arr[i]-arr[i-1];
				int sub3 = arr[i]-arr[i+1];
				int sub4 = arr[i]-arr[i+2];
				if(sub1>0&&sub2>0&&sub3>0&&sub4>0) { //조망권 확보 조건
					// sub값들 중 minsub보다 작은 값 있으면 minsub값 업데이트
					if(minsub>sub1) {
						minsub = sub1;
					}
					if(minsub>sub2) {
						minsub = sub2;
					}
					if(minsub>sub3) {
						minsub = sub3;
					}
					if(minsub>sub4) {
						minsub = sub4;
					}
					sum += minsub;     //각 건물마다 조망권 확보 세대수 더하기
				}
			}
			System.out.println("#"+tc+" "+sum);  //tc마다 출력
		}//tc순회 끝
	}
}
