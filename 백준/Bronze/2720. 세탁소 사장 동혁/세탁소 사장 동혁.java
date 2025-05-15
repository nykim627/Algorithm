import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int[] cnt = new int[4];
			int[] money = {25, 10, 5, 1};
			int change = Integer.parseInt(br.readLine());
			for(int i=0;i<4;i++) {
				cnt[i] = change/money[i];
				change = change%money[i];
			}
			for(int i=0;i<4;i++) {
				System.out.print(cnt[i]+" ");
			}
			System.out.println();
		}

		br.close();

	}
}
