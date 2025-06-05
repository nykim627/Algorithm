import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack();
		for(int i=0;i<N;i++) {
			String[] order = br.readLine().split(" ");
			switch(order[0]) {
			case "1":
				stack.add(Integer.parseInt(order[1]));
				break;
			case "2":
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			case "3":
				sb.append(stack.size()).append("\n");
				break;
			case "4":
				if(stack.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
			case "5":
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			}
		}
		
		System.out.println(sb.toString());

	}
}