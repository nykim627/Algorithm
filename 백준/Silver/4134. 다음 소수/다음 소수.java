import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			BigInteger bigint = new BigInteger(br.readLine());
			if (bigint.isProbablePrime(11)) {
				sb.append(bigint).append("\n");
			} else {
				sb.append(bigint.nextProbablePrime()).append("\n");
			}
//			long num = Long.parseLong(br.readLine());
//			if(num==0 || num==1) {
//				sb.append("2\n");
//				continue;
//			}
//			for(long j=num;j<=4*Math.pow(10, 9);j++) {
//				boolean isPrime = true;
//				for(long k=2;k<j;k++) {
//					if(j%k==0) {
//						isPrime = false;
//						break;
//					}
//				}
//				if(isPrime) {
//					sb.append(j).append("\n");
//					break;
//				}
//			}
		}

		System.out.println(sb.toString());
	}
}
