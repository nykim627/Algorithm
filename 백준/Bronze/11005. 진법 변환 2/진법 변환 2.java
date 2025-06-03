import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		//더이상 나눠지지 않을때까지 몫을 나눈다.
		while(N/B>0) {
			if(N%B<=9) {
				sb.append(N%B);
			}else {
				char tmp = (char) ('A'+ (N%B-10));
				sb.append(tmp);
			}
			N /= B;
		}
		//마지막 몫에 대한 계산
		if(N>0) {
			if(N<=9) {
				sb.append(N);
			}else {
				char tmp = (char) ('A'+ (N-10));
				sb.append(tmp);
			}
		}
		
		sb.reverse();
		
		System.out.println(sb.toString());
		
	}
}
