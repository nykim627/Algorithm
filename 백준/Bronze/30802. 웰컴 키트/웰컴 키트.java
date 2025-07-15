import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numberPerSize = new int[6];
		for(int i=0;i<6;i++) {
			numberPerSize[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int resT = 0;
		for(int i=0;i<6;i++) {
			resT += numberPerSize[i]/T;
			if(numberPerSize[i]%T!=0) resT++;
		}
		
		int resP1 = N/P;
		int resP2 = N%P;
		
		sb.append(resT).append("\n").append(resP1).append(" ").append(resP2);
		
		System.out.println(sb.toString());
	}
}
