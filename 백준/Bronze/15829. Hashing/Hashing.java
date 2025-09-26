import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		BigInteger sum = new BigInteger("0");
		BigInteger r = new BigInteger("31");
		BigInteger M = new BigInteger("1234567891");
		for(int i=0;i<L;i++) {
			String tmp = String.valueOf(str.charAt(i)-'a'+1);
			BigInteger num = new BigInteger(tmp);
			BigInteger pow = r.pow(i);
			sum = sum.add(pow.multiply(num));
//			System.out.println(tmp);
//			System.out.println(num.toString());
//			System.out.println(pow.toString());
//			System.out.println(pow.multiply(num));
//			System.out.println(sum.toString());
		}
		System.out.println(sum.mod(M).toString());
	}

}