import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack;
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			stack = new Stack();
			boolean isVPS = true;
			for(int j=0;j<tmp.length();j++) {
				if(tmp.charAt(j)=='(') {
					stack.add(1);
				}else {
					if(stack.isEmpty()) {
						isVPS = false;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.size()==0 && isVPS) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}
}