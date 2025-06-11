import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] dp = new int[30][30];
		
		for(int n=0;n<30;n++) {
			for(int r=0;r<=n;r++) {
				if(r==0||r==n) {
					dp[n][r] = 1;
				}else {
					dp[n][r] = dp[n-1][r-1] + dp[n-1][r];
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(dp[M][N]).append("\n");
		}
		System.out.println(sb.toString());
	}
	

}
