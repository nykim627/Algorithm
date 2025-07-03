import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for(int i=0;i<N;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i=N-1;i>=0;i--) {
			while(K>=coins[i]) {
				K -= coins[i];
				cnt++;
			}
		}
		
		sb.append(cnt);
		System.out.println(sb.toString());
	}
}
