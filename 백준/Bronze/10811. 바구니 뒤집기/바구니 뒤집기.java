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
		for(int i=1;i<=n;i++) {
			basket[i] = i;
		}
		for(int t=0;t<m;t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			for(int idx=i;idx<=(i+j)/2;idx++) {
				int tmp = basket[idx];
				basket[idx] = basket[i+j-idx];
				basket[i+j-idx] = tmp;
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.print(basket[i]+" ");
		}

		br.close();

	}
}
