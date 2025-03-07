import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static int cntGu; // 규영이가 이긴횟수
	static int cntIn; // 인영이가 이긴횟수 (무승부는 세지 않음)
	static int N = 9;
	static boolean[] cards; // 총 카드들 - 규영이가 가지고 있는 번호의 인덱스값을 true로 바꿀 것
	static int[] cardsGu; // 규영이 카드들(순서o)
	static int[] cardsIn; // 인영이 카드들(순서x)
	static int[] result; // 인영이 카드들(순서o)

	public static void main(String[] args) throws IOException {
		// 서로 다른 두퀸 -> 순열문제!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			cards = new boolean[19];
			cardsGu = new int[9];
			cardsIn = new int[9];
			cntGu = 0;
			cntIn = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String str = st.nextToken();
				cards[Integer.parseInt(str)] = true;
				cardsGu[i] = Integer.parseInt(str);
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!cards[i])
					cardsIn[idx++] = i;
			}

			visited = new boolean[N];
			result = new int[N];
			perm(0);

			bw.write("#" + tc + " " + cntGu + " " + cntIn + "\n"); // 결과출력
		} // tc순회

		bw.flush();
		bw.close();
		br.close();
	}// main

	static void perm(int depth) {
		// 종료
		if (depth == N) {
			int scoreGu = 0, scoreIn = 0;
			for (int i = 0; i < N; i++) {
				if (cardsGu[i] > result[i]) {
					scoreGu += cardsGu[i]+result[i];
				} else if (cardsGu[i] < result[i]) {
					scoreIn += cardsGu[i]+result[i];
				}
			}
			if (scoreGu > scoreIn)
				cntGu++;
			else if (scoreGu < scoreIn)
				cntIn++;
			return;
		}

		// 재귀
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				result[depth] = cardsIn[i];
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false; //백트래킹
			}
		}

	}//perm

}
