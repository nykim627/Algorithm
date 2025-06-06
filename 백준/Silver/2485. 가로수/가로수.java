import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] diff = new int[N-1];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<N-1;i++) {
			diff[i] = arr[i+1]-arr[i];
		}
		
		int gcd = diff[0];
		for(int i=1;i<N-1;i++) {
			gcd = gcdFunc(gcd, diff[i]);
		}

		int res = 0;
		for(int i=0;i<N-1;i++) {
			res += diff[i]/gcd - 1;
		}
		System.out.println(res);

	}
	
	public static int gcdFunc(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return a;   //이게 최대공약수!!
	}
}