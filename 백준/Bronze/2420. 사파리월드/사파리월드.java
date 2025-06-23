import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static long N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		long res = Math.abs(M-N);
		sb.append(res);
		
		System.out.println(sb.toString());
	}
	
}
