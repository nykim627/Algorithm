import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while(!(a==0 && b==0 && c==0)) {
			int max = Math.max(Math.max(a, b),c);
			int min = Math.min(Math.min(a, b),c);
			int other = a+b+c-max-min;
			if(min*min + other*other == max*max) sb.append("right\n");
			else sb.append("wrong\n");
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb.toString());
	}
	
}
