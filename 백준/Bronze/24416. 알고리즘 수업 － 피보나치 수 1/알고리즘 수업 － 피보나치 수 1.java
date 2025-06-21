import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] f;
	static int cnt1=0, cnt2=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		f = new int[n+1];
		
		fib(n);
		fibonacci(n);
		
		sb.append(cnt1).append(" ").append(cnt2);
		System.out.println(sb.toString());
	}
	
	//재귀
	static int fib(int n) {
		if(n==1 || n==2) {
			cnt1++;
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	//dp
	static void fibonacci(int n) {
		if(n <= 2) f[n] = 1;
		else {
			for(int i=3;i<=n;i++) {
				f[i] = f[i-1] + f[i-2];
				cnt2++;
			}
		}
	}
	
}
