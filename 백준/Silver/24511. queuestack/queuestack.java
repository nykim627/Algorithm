import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main { 
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; //ex) 0번째 자료구조는 큐(0), 1번째 자료구조는 스택(1), ...
		Deque<Integer> queuestack = new LinkedList<Integer>(); //queuestack

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int order = Integer.parseInt(st.nextToken());
			arr[i] = order;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(arr[i]==0) {
				queuestack.addFirst(num);
			}else {
				continue; //stack은 어짜피 입력받은 값이 그대로 나오므로 굳이 안넣어도 됨.
			}
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			queuestack.offer(Integer.parseInt(st.nextToken())); // 입력받은 수
			sb.append(queuestack.poll()).append(" ");
		}

		System.out.println(sb.toString());
	}

}

/*
5
0 0 1 0 1
1 2 3 4 5
8
11 19 12 15 14 18 17 10 100
답: 4 2 1 11 19 12 15 14 
*/
