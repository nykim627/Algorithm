import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int two = 0;
		int five = 0;
		for(int num=1;num<=N;num++) {
			int i = num;
			while(i%2==0 || i%5==0) {
				if(i%2==0) {
					if(i%5==0) {
						i/=10;
						two++;
						five++;
					}else {
						i/=2;
						two++;
					}
				}else {
					if(i%5==0) {
						i/=5;
						five++;
					}else {
						break;
					}
				}
			}
		}
		System.out.println(Math.min(two, five));
	}
}