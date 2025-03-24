import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (max < arr[i])
					max = arr[i];
			}

			int sub = 0;
			int odd = 0;
			int even = 0;
			for (int e : arr) {
				sub = Math.abs(max - e);
				odd += sub % 2;
				even += sub / 2;
			}

			int res = 0;
			if (odd > even) {
				res = odd * 2 - 1;
			} else if(odd==even){
				res = even!=0 ? even*2 : 0;
			} else {
				while(odd<even) {
					even--;
					odd+=2;
				}
				if(odd-even==2) {
					res = (even+1) * 2;
				}else if(odd-even==1) {
					res = odd*2-1;
				}else if(odd-even==0) {
					res = even*2;
				}
			}

			System.out.println("#" + tc + " " + res);

		} // tc순회
	}// main
}
