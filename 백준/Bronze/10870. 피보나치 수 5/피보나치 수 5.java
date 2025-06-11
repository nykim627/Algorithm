import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] fibo = new int[21];
		for(int i=1;i<=20;i++) {
			if(i<=1) fibo[i] = i;
			else {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(fibo[N]);
		
	}

}
