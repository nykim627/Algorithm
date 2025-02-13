import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt(); //tc수

		for (int tc = 1; tc <= t; tc++) {
			int k = sc.nextInt(); //정수 k(1<=k<=100000)
			
			Stack<Integer> stack = new Stack<Integer>(); //tc마다 stack새로
			
			for(int i=0;i<k;i++) {
				int val = sc.nextInt();
				if(val==0) {//0인 경우 지울 수 있는 수가 보장되므로 예외처리 불필요
					stack.pop(); //가장 최근 수 지우기
				}else {
				stack.add(val);
				}
			}//스택에 정수넣기 끝
			
			//스택 내 값의 총합구하기 (스택 크기 달라짐에 주의)
			int sum = 0; 
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + tc + " " + sum);
		} //tc 반복 끝
	}
}
