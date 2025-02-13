import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt(); // tc수

		for (int tc = 1; tc <= t; tc++) {
			String temp = sc.next(); //괄호 문자열 (최대 100000)
			String str = temp.replace("()", "*"); //레이저를 문자 한개로 바꿔줌
//			System.out.println(str);
			Stack<Character> stack = new Stack<>(); // tc마다 stack새로
			
			int sum = 0; //누적합
			for(char e: str.toCharArray()) {
				if(e=='(') {
					stack.push(e);
					sum += 1; //막대기 개수 하나 추가
				}else if(e=='*') {
					sum += stack.size(); //레이저가 쏜 막대기 개수
				}
				else { // e==')'
					stack.pop();
				}
			}
			
			
			System.out.println("#" + tc + " " + sum);
		} // tc 반복 끝
	}
}
