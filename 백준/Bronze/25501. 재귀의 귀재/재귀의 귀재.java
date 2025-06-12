import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String s = br.readLine();
			cnt = 0;
			sb.append(isPalindrome(s)).append(" ");
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static int recursion(String s, int l, int r) {
		cnt++;
		if(l>=r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else return recursion(s, l+1, r-1);
	}
	
	static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}
}
