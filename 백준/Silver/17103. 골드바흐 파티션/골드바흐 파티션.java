import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] cnt = new boolean[1000001];
		for(int i=2;i<=1000000;i++) {
			boolean isPrime = true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) cnt[i] = true;
		}
//		for(int i=1;i<=1000000;i++) {
//			if(cnt[i]) System.out.println(i);
//		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int num = Integer.parseInt(br.readLine());
			int res = 0;
			for(int i=2;i<=num/2;i++) {
//				System.out.println(cnt[i]+" & "+cnt[num-i]);
				if(cnt[i] && cnt[num-i]) res++;
			}
			sb.append(res).append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
