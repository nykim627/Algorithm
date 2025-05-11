import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=0;j<(n-i);j++) {
				sb.append(" ");
			}
			for(int j=n-i;j<n;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
		br.close();
		
	}
}
