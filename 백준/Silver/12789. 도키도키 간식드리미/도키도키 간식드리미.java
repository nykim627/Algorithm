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

		int num = 0;
		boolean isOk = true;
		while (!q.isEmpty()) {
			int curr = q.peek();
			if (curr == num + 1) {
				num = q.poll();
			} else {
				if (stack.isEmpty()) {
					stack.add(q.poll());
				} else {
					int stacknum = stack.peek();
					if (stacknum < curr) {
						if (stacknum == num + 1) {
							num = stack.pop();
						} else {
							isOk = false;
							break;
						}
					} else {
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
