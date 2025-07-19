import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList();
		for(int i=0;i<T;i++) {
			String[] arr = br.readLine().split(" ");
			switch(arr[0]) {
			case "push":
				q.offer(Integer.parseInt(arr[1]));
				break;
			case "front":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.peekFirst()).append("\n");
				break;
			case "back":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.peekLast()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "pop":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.poll()).append("\n");
				break;
			case "empty":
				if(q.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
