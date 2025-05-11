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

		int[] cnt = new int[31];
		for(int i=1;i<=28;i++) {
			int tmp = Integer.parseInt(br.readLine());
			cnt[tmp]++;
		}
		
		for(int i=1;i<=30;i++) {
			if(cnt[i]==0) System.out.println(i);
		}

		br.close();

	}
}
