import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //tc수
		
		for(int tc=1;tc<=T;tc++) {
			
			int n = sc.nextInt();
			String[] arr = new String[n];
			
			//배열값 입력
			for(int i=0;i<n;i++) {
				arr[i] = sc.next();
			}
			
						
			//절반으로 나눈 카드덱의 크기 (홀수이면 첫 묶음에 한장이 더 들어감)
			int len = arr.length%2==0 ? arr.length/2 : arr.length/2+1 ;
			
			String[] subArr1 = new String[len];   //첫번째 카드덱
			String[] subArr2 = new String[n-len]; //두번째 카드덱
			
			int idx1 = 0;
			int idx2 = 0;
			for(int i=0;i<n;i++) {
				if(i<len) {
					subArr1[idx1++] = arr[i];
				}else {
					subArr2[idx2++] = arr[i];
				}
			}
			
			String[] ans = new String[n]; //결과저장배열
			
			int idx = 0; //결과저장배열의 인덱스
			if(arr.length%2==0) { //전체카드 크기가 짝수면
				for(int i=0;i<len;i++) { //처음부터 차곡차곡
					ans[idx++] = subArr1[i];
					ans[idx++] = subArr2[i];
				}
			}else { //홀수면
				for(int i=0;i<len-1;i++) { //두번째 카드덱 크기만큼 for문 돌고
					ans[idx++] = subArr1[i];
					ans[idx++] = subArr2[i];
				}
				ans[idx++] = subArr1[len-1]; //마지막에 첫번째 카드덱의 가장 마지막 카드 붙여주기
			}
			
			//결과 출력
			System.out.print("#"+tc);
			for(int i=0;i<n;i++) {
				System.out.print(" "+ans[i]);
			}
			System.out.println();
			
		}//tc순회끝
		
	}

}
