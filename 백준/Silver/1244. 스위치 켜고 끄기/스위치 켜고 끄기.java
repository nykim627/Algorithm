import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = st.nextToken().equals("0") ? false : true;
		}
		
		int stu = Integer.parseInt(br.readLine());
		for(int i=0;i<stu;i++) {
			String[] order = br.readLine().split(" ");
			if(order[0].equals("1")) { //male
				int num = Integer.parseInt(order[1]);
				for(int j=1;j<=N/num;j++) {
					arr[num*j] = !arr[num*j];
				}
			}else {
				int num = Integer.parseInt(order[1]);
				for(int j=0;j<=Math.min(num-1, N-num);j++) {
					if(arr[num-j]==arr[num+j]) {
						arr[num-j] = arr[num+j] = !arr[num+j];
					}else {
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			sb.append(arr[i] ? 1 : 0).append(" ");
			if(i%20==0) sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
