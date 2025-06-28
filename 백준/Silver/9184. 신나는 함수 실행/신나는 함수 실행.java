import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int a, b, c;
	static int[][][] dp;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		dp = new int[21][21][21];
		dp[0][0][0] = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		while(!(a==-1&&b==-1&&c==-1)) {
			sb.append("w(").append(a).append(", ")
			.append(b).append(", ").append(c).append(") = ")
			.append(w(a,b,c)).append("\n");
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb.toString());
	}
	
	public static int w(int a, int b, int c) {
		if(a<=0||b<=0||c<=0) return 1;
		if(a>20||b>20||c>20) return w(20,20,20);
		if(dp[a][b][c]!=0) return dp[a][b][c];
		if(a<b && b<c) {
			return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
		}else {
			return dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
		}
	}

}
