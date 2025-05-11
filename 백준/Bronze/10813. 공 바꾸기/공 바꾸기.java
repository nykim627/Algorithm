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

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] basket = new int[n+1];
		for(int idx=0;idx<n+1;idx++) {
			basket[idx] = idx;
		}
		for(int num=0;num<m;num++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int tmp = basket[i];
			basket[i] = basket[j];
			basket[j] = tmp;
		}
		
		for(int i=1;i<n+1;i++) {
			System.out.print(basket[i]+" ");
		}

		br.close();

	}
}
