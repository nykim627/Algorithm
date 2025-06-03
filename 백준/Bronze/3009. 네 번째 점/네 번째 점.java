import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int[] cntX = new int[1001];
		int[] cntY = new int[1001];
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cntX[x]++;
			cntY[y]++;
		}
		
		for(int i=0;i<1001;i++) {
			if(cntX[i]==1) System.out.print(i+" ");
		}

		for(int i=0;i<1001;i++) {
			if(cntY[i]==1) System.out.print(i);
		}
		
	}
}

