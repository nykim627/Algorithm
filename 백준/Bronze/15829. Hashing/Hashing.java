import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long sum = 0;
		for(int i=0;i<L;i++) {
			long num = str.charAt(i)-'a'+1;
			sum += num*Math.pow(31, i);
		}
		System.out.println(sum%1234567891);
	}

}