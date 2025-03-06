
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	
    public static void main(String[] args) {
		//거듭제곱 함수를 재귀호출을 이용하여 구현하라.
    	Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1;tc<=T;tc++) {
			int tcNum = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.println("#"+tcNum+" "+pow(N,M)); //결과출력
		}//tc순회끝
	}//main
    
    static int pow(int n, int m) {
    	//종료조건
    	if(m==0) return 1;
    	
    	//재귀부분
    	if(m%2==0) {
    		int tmp = pow(n,m/2);
    		return tmp*tmp;
    	}else {
    		int tmp = pow(n,m/2);
    		return tmp*tmp*n;
    	}
    }//pow
}