import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int sum = 0;
		boolean isOddIdx = false;
		for(int i=0;i<12;i++) { //12자리까지
			char c = str.charAt(i);
			if(c=='*') {
				if(i%2!=0) {
					isOddIdx = true;
				}
			}else {				
				int num = c-'0';
				if(i%2==0) {
					sum += num;
				}else {
					sum += 3*num;
				}
			}
		}
		int m = str.charAt(12)-'0';
		int num = 0;
		int res = 0;
		for(int i=0;i<=9;i++) {
			if(isOddIdx) {
				num = (sum+3*i)%10 + m;
				if(num%10==0) {
					res = i;
					break;
				}
			}else {
				num = (sum+i)%10 + m;
				if(num%10==0) {
					res=i;
					break;
				}
			}
		}
		
		sb.append(res);
		
		System.out.println(sb.toString());
	}
}
