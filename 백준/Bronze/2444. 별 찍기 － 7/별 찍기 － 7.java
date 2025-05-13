import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<n;i++) {
			for(int j=(n-i);j>0;j--) {
				sb.append(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for(int i=n;i>0;i--) {
			for(int j=1;j<=n-i;j++) {
				sb.append(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());

		br.close();

	}
}
