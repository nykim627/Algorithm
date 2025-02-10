

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 입력
		int T = sc.nextInt();
		
		//tc 순회
		for(int tc=1;tc<=T;tc++) {
			int max = 0;
			
			int[] arr = new int[10]; //10개수 저장하는 배열 생성

			//배열순회하며 값 입력
			for(int i=0;i<10;i++) {
				arr[i]=sc.nextInt();
			}
			
			//max보다 큰 수가 있다면 max값 교체
			for(int i=0;i<10;i++) {
				if(max<arr[i]) {
					max = arr[i];
				}
			}
			System.out.println("#"+tc+" "+max);  //tc마다 출력
		}//tc순회 끝
		sc.close();   //스캐너 닫아주기
	}
}
