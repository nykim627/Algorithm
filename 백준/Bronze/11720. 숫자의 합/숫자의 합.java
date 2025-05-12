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

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] arr = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = s.charAt(i)-'0';
			sum += arr[i];
		}
		System.out.println(sum);
		
		br.close();

	}
}
