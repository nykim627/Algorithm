import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for(int i=0;i<s.length();i++) {
			int idx = s.charAt(i)-'a';
			if(arr[idx]==-1) arr[idx] = i;
		}
		
		for(int i=0;i<26;i++) {
			System.out.print(arr[i]+" ");
		}
		
		br.close();

	}
}
