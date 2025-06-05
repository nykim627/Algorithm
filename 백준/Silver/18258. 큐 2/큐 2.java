import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList();
		
		for(int i=0;i<N;i++) {
			String[] order = br.readLine().split(" ");
			switch(order[0]) {
			case "push":
				q.add(Integer.parseInt(order[1]));
				break;
			case "pop":
				sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(q.isEmpty() ? -1 : q.getFirst()).append("\n");
				break;
			case "back":
				sb.append(q.isEmpty() ? -1 : q.getLast()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());

	}
}