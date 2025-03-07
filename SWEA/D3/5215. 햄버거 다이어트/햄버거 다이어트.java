import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int[] T; // 각 재료에 대한 민기의 맛에 대한 점수
	static int[] K; // 각 재료의 칼로리
	static boolean[] visited; // 재료 방문배열
	static int totalScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcases; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			T = new int[N];
			K = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[N]; // 재료 방문배열
			totalScore = Integer.MIN_VALUE;
			powerset(0, 0, 0);

			bw.write("#" + tc + " " + totalScore + "\n"); // 결과출력
		} // tc순회

		bw.flush();
		bw.close();
		br.close();
	}// main

	static void powerset(int depth, int cal, int score) {
		// 종료
		if (cal > L)
			return; //백트래킹
		if (depth == N) {
			totalScore = Math.max(totalScore, score);
			return;
		}

		// 재귀
		powerset(depth + 1, cal, score); // 해당 재료 사용x

		powerset(depth + 1, cal + K[depth], score + T[depth]); // 해당 재료 사용o

	}// powerset

}
