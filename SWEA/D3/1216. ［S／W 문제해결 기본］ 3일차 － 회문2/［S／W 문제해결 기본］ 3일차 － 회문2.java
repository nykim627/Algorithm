import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = 10; //tc수

		for (int tc = 1; tc <= t; tc++) {
			int tcNum = sc.nextInt(); //tc번호
			char[][] charArr = new char[100][100];
			
			//100*100 입력
			for(int r=0;r<100;r++) {
				charArr[r] = sc.next().toCharArray();
			}
			
			//회문길이를 최대부터 찾기
			int max = 1; //나중에 len 대입
			Loop:
			for(int len=100;len>=1;len--) { //길이고정
				for(int i=0;i<100;i++) { //행or열 고정
					for(int j=0;j<=(100-len);j++) {
						//팰린드롬수 체크
						boolean isPal = true;
						for(int k=0;k<len/2;k++) { //가로회문 체크
							if(charArr[i][k+j] != charArr[i][len-1-k+j]) {
								isPal = false;
								break;
							}
						}
						if(isPal) {
							max = len;
							break Loop;
						}
						isPal = true; //이거빼먹음ㅠㅠㅠ
						for(int k=0;k<len/2;k++) { //세로회문체크
							if(charArr[k+j][i] != charArr[len-1-k+j][i]) {
								isPal = false;
								break;
							}
						}
						if(isPal) {
							max = len;
							break Loop;
						}
					}
				}
			}//길이 for문 끝
			System.out.println("#" + tcNum + " " + max);
		} //tc 반복 끝
	}
}
