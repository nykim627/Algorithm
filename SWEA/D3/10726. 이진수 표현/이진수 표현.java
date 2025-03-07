import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N; //1 ≤ N ≤ 30
	static int M; //0 ≤ M ≤ 10^8
	static String status; //비트 상태

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcases; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		
			if((M & (1<<N)-1) >= (1<<N)-1) {
				status = "ON";
			}else {
				status = "OFF";
			}
			bw.write("#" + tc + " " + status + "\n"); // 결과출력
		} // tc순회

		bw.flush();
		bw.close();
		br.close();
	}// main

}
