import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N; //(1 ≤ N ≤ 20)
	static int K; //(1 ≤ K ≤ 1000)
	static int[] arr; //N개의 자연수 수열 A
	static int cnt; //부분 수열의 합이 K가 되는 경우의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcases; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			cnt = 0;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken()); //1이상 100이하
			}
			check(0,0);
			
			bw.write("#" + tc + " " + cnt + "\n"); // 결과출력
		} // tc순회

		bw.flush();
		bw.close();
		br.close();
	}// main
	
	static void check(int depth, int sum) {
		//종료
		if(depth==N) {
			if(sum==K) cnt++;
			return;
		}
		
		check(depth+1, sum); //선택안함
		check(depth+1, sum+arr[depth]); //선택함
		
	}

}
