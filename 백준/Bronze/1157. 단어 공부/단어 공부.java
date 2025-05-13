import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[26];
		String input = br.readLine().toUpperCase();
		for(int i=0;i<input.length();i++) {
			char tmp = input.charAt(i);
			arr[tmp-'A']++;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<26;i++) {
			max = Math.max(arr[i],  max);
		}
		int cnt = 0;
		int idx = -1;
		for(int i=0;i<26;i++) {
			if(arr[i]==max) {
				cnt++;
				idx = i;
			}
		}
		if(cnt==1) {
			System.out.println((char)(idx+'A'));
		}else {
			System.out.println("?");
		}
		
		br.close();

	}
}
