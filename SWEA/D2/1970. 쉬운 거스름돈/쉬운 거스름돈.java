import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] moneys = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int[] moneyCnt = new int[moneys.length];
			int idx=0;
			int N = Integer.parseInt(br.readLine());
			while(N>=0 && idx<8) {
				if(N>=moneys[idx]) {
					N -= moneys[idx];
					moneyCnt[idx]++;
				}
				else idx++;
			}
			System.out.println("#"+tc);
			for(int e: moneyCnt) {
				System.out.print(e+" ");
			}
			System.out.println();
		}

	}

}
