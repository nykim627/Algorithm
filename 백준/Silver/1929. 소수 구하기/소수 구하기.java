import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		for (int i = M; i <= N; i++) {
			boolean isPrime = true;
			//에라토스테네스의 체 이용하기!! 
			//각 수가 갖는 약수는 해당 수의 제곱근을 기준으로 대칭을 이루기 때문에,
			//n이 소수임을 판단하기 위해서는 2부터 n의 제곱근까지 나누어 떨어지는지만 확인하면 됨.
			if(i==0 || i==1) {
				isPrime=false;
			}
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					isPrime=false;
					break;
				}
			}
			if(isPrime) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
