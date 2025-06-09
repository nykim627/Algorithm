import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		for(int t=0;t<N;t++) {
			String[] order = br.readLine().split(" ");
			switch(order[0]) {
			case "1":
				dq.addFirst(Integer.parseInt(order[1]));
				break;
			case "2":
				dq.addLast(Integer.parseInt(order[1]));
				break;
			case "3":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.removeFirst()).append("\n");
				}
				break;
			case "4":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.removeLast()).append("\n");
				}
				break;
			case "5":
				sb.append(dq.size()).append("\n");
				break;
			case "6":
				if(dq.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "7":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.getFirst()).append("\n");
				}
				break;
			case "8":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.getLast()).append("\n");
				}
				break;
			}
			
		}
		
		System.out.println(sb.toString());
	}
}
