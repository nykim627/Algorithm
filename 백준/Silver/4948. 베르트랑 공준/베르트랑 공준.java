import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			if (n == 1) {
				sb.append("1\n");
			} else {
				int num = 0;
				for(int j=n+1;j<=2*n;j++) {
					boolean isPrime = true;
					for (int i = 2; i <= Math.sqrt(j); i++) {
						if(j%i==0) {
							isPrime = false;
							break;
						}
					}
					if(isPrime) num++;
				}
				sb.append(num).append("\n");
			}
			n = Integer.parseInt(br.readLine());
		}

		System.out.println(sb.toString());
	}
}
