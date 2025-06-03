import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i=0;i<str.length();i++) {
			char tmp = str.charAt(str.length()-1-i);
			if(tmp == '0') {
				continue;
			}else if(tmp >= '1' && tmp <= '9') {
				sum += Math.pow(B, i) * (tmp-'0');
			}else {
				sum += Math.pow(B, i) * (10+(tmp-'A'));
			}
		}
		
		System.out.println(sum);

	}
}
