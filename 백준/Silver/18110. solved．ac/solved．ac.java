import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cut = (int) Math.round((double) N*0.15);
//		System.out.println(cut);
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i=cut;i<N-cut;i++) {
//			System.out.println(i);
			sum += arr[i];
//			System.out.println(sum);
		}
		int ans = (int) Math.round((double) sum/(N-2*cut));
		System.out.println(ans);
	}
}