import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(fact(M).divide(fact(N).multiply(fact(M-N)))).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static BigInteger fact(int n) {
		if(n==0) {
			return new BigInteger("1");
		}
		if(n==1) {
			return new BigInteger("1");
		}
		return fact(n-1).multiply(new BigInteger(String.valueOf(n)));
		
	}
	

}
