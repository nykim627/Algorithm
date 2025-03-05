import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//아이디어: 중복 조합. w,b,r 중에 중복 허용해서 n개 뽑는다. 이때 각각 최소 1개씩 들어가도록 한다. 뽑기만 해두면 정렬을 자동으로 된다.(윗부분흰색, 중간부분파랑, 아랫부분빨강)
//반복문 아이디어: 
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 각 색으로 칠해야 하는 누적 비용 배열
			int[] wPrefix = new int[N + 1]; // 1~i행을 모두 흰색으로
			int[] bPrefix = new int[N + 1]; // 1~i행을 모두 파란색으로
			int[] rPrefix = new int[N + 1]; // 1~i행을 모두 빨간색으로
			for (int r = 1; r <= N; r++) {
				int costW = 0, costB = 0, costR = 0;
				String row = br.readLine();
				for (int c = 0; c < M; c++) {
					char tmp = row.charAt(c);
					if (tmp != 'W')
						costW++;
					if (tmp != 'B')
						costB++;
					if (tmp != 'R')
						costR++;
				}
				wPrefix[r] = wPrefix[r - 1] + costW;
				bPrefix[r] = bPrefix[r - 1] + costB;
				rPrefix[r] = rPrefix[r - 1] + costR;
			} // 값 입력 끝

			int min = Integer.MAX_VALUE;
			for (int w = 1; w <= N - 2; w++) {
				for (int b = w + 1; b <= N - 1; b++) {
					int sum = wPrefix[w] + (bPrefix[b] - bPrefix[w]) + (rPrefix[N] - rPrefix[b]);
					min = Math.min(min, sum);
				}
			}
			System.out.println("#" + tc + " " + min);
		} // tc순회 끝

		bw.flush();
		bw.close();
		br.close();
	}// main

}
