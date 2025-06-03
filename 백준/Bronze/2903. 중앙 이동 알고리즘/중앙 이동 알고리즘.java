import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dot = 2;
		int n = 1;
		while(n<=N) {
			dot = dot*2 - 1;
			n++;
		}
		
		System.out.println(dot*dot);
		
	}
}
