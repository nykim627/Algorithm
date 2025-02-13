import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = 10; // tc수

		for (int tc = 1; tc <= t; tc++) {
			int len = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack = new Stack<>(); // tc마다 stack새로

			HashMap<Character, Character> map = new HashMap<>();

			map.put('(', ')');
			map.put('{', '}');
			map.put('[', ']');
			map.put('<', '>');

//			System.out.println(map);

			boolean isOk = true;

			// 괄호 전체 순회하면서 유효성 판단
			for (char e : str.toCharArray()) {
				if (map.keySet().contains(e)) { // e가 여는괄호 중 하나라면
					stack.push(e);
				} else { // e가 닫는괄호 중 하나라면
					if (stack.isEmpty()) {
						isOk = false;
						break;
					} else {
						// 스택의 가장 최근값(열린괄호)에 대응하는 map값(닫힌괄호)가 e와 같은지 췤
						char tmp = stack.pop();
						if (map.get(tmp) != e) {
							isOk = false;
							break;
						}
					}
				}
			}

			// 순회 후 유효성 판단
			int ok;
			if (isOk && stack.isEmpty()) { //정답: isOk=true && 공백o
				ok = 1;
			} else {
				ok = 0;
			}
			
			System.out.println("#" + tc + " " + ok);
		} // tc 반복 끝
	}
}
