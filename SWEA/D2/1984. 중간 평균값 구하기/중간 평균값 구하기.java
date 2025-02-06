import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 입력
		int T = sc.nextInt();
		
		//tc 순회
		for(int tc=1;tc<=T;tc++) {
			int max = 0; //최대값 저장
			int min = 10000; //최소값 저장
			float restsum = 0; //최대최소 제외 8개값의 합. 자료형은 float.
			int restavg = 0; //최대최소 제외 8개값 평균
			
			int[] arr = new int[10]; //10개수 저장하는 배열 생성

			//배열순회하며 값 입력
			for(int i=0;i<10;i++) {
				arr[i]=sc.nextInt();
			}
			
			//최대값 최소값 구하기
			for(int i=0;i<10;i++) {
				//max보다 큰 수가 있다면 max값 교체
				if(max<arr[i]) {
					max = arr[i];
				}
				//min보다 작은 수 있다면 min값 교체
				if(min>arr[i]) {
					min = arr[i];
				}
			}
			
			//restsum구하기
			for(int i=0;i<10;i++) {
				if(!(arr[i]==max|arr[i]==min)) { //최대값이나 최소값 아닐때만 더하기
					restsum += arr[i];
				}
			}
			
			//restavg구하기
//			System.out.println(restsum/8);
			restavg = Math.round(restsum/8); //입력값은 float. 소수점 첫째자리에서 반올림
			
			System.out.println("#"+tc+" "+restavg);  //tc마다 출력
		}//tc순회 끝
	}
}
