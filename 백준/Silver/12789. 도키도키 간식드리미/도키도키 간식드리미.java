import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}

		Stack<Integer> stack = new Stack();

		int num = 0; //라인 통과하는 번호표
		boolean isOk = true;
		while (!q.isEmpty()) {
			int curr = q.peek();
			if (curr == num + 1) {  //큐의 제일 맨앞 번호표가 다음번호표일 때 
				num = q.poll();     //라인 통과한 번호 갱신
			} else {
				if (stack.isEmpty()) {  //스택이 비어있다면 바로 대기열로 ㄱㄱ
					stack.add(q.poll());
				} else {  //스택이 비어있지 않다면 스택의 가장 위의 값과 비교해야 함
					int stacknum = stack.peek();  
					if (stacknum < curr) { 
						if (stacknum == num + 1) {
							num = stack.pop();
						} else {  //대기열에 있는 번호는 무조건 (마지막 들어온 번호부터) 오름차순이어야 함
							isOk = false;
							break;
						}
					} else { //대기열에 있는 번호는 무조건 (마지막 들어온 번호부터) 오름차순이어야 함
						stack.add(q.poll());
					}
				}
			}
		}

		if(isOk) sb.append("Nice\n");
		else sb.append("Sad\n");

		System.out.println(sb.toString());
	}
}
