import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Deque<int[]> dq = new ArrayDeque<>(); //LinkedList가 ArrayDeque보다 메모리 사용량이 더 많다
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			dq.offer(new int[] {i,Integer.parseInt(st.nextToken())});
		}
		
		int move = 0;
		for(int tc=0;tc<N;tc++) {
			if(move>0) {
				for(int i=move;i>0;i--) {
					dq.addLast(dq.removeFirst());
				}
				int[] tmp = dq.removeLast();
				move = tmp[1];
				sb.append(tmp[0]).append(" ");
				
			}else if(move<0) {
				for(int i=move;i<0;i++) {
					dq.addFirst(dq.removeLast());
				}
				int[] tmp = dq.removeFirst();
				move = tmp[1];
				sb.append(tmp[0]).append(" ");
			}else {
				int[] tmp = dq.removeFirst();
				move = tmp[1];
				sb.append(tmp[0]).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}
