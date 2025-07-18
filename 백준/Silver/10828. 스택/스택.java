import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack();
		for(int i=0;i<T;i++) {
			String[] arr = br.readLine().split(" ");
			switch(arr[0]) {
			case "push":
				stack.push(Integer.parseInt(arr[1]));
				break;
			case "top":
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.peek()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "pop":
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.pop()).append("\n");
				break;
			case "empty":
				if(stack.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
