import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] sel;
	static int N;
	static int[] data;
	static int R;
	static List<int[]> result;

	/*아이디어: 
	 * 숫자0부터 숫자N-1까지 저장된 크기 N의 배열(data)에서 R개(=N/2)의 숫자를 고른다.
	 * 고른 R개의 재료로 음식 A를, 나머지 R개의 재료로 음식 B를 만든다.
	 * 2차원 배열 arr에서 각 음식A, B에 들어가는 R개의 모든 재료의 시너지(arr[i][j]+arr[j][i])의 총합을 계산한다.
	 * 총합의 차의 최솟값을 구하고 출력한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			
			int[][] arr = new int[N][N];
			for(int r=0;r<N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			data = new int[N];
			for(int i=0;i<N;i++) {
				data[i] = i;
			}
			sel = new int[R];
			result = new ArrayList<>();
			comb(N,R); //음식 A에 들어갈 재료 번호 조합 result 구함
			
			int min = Integer.MAX_VALUE;
			for(int[] A: result) {
//				System.out.println(Arrays.toString(A));
				List<Integer> listA = new ArrayList<>();
				for (int i = 0; i < A.length; i++) {
					listA.add(A[i]);
				}
				int[] B = new int[R];
				int idx=0;
				//음식B 재료조합 구하기(음식 A에 안들어간 애들 총집합)
				for(int i=0;i<N;i++) {
					if(!listA.contains(i)) {
						B[idx++] = i;
					}
				}
//				System.out.println(Arrays.toString(B));
				int sumA = 0;
				for(int i=0;i<A.length-1;i++) {
					for(int j=i;j<A.length;j++) {
						sumA+=arr[A[i]][A[j]]+arr[A[j]][A[i]];
					}
				}
				int sumB = 0;
				for(int i=0;i<B.length-1;i++) {
					for(int j=i;j<B.length;j++) {
						sumB+=arr[B[i]][B[j]]+arr[B[j]][B[i]];
					}
				}
				min = Math.min(min, Math.abs(sumA-sumB));
			}
			System.out.println("#" + tc + " " + min);
		} // tc순회 끝

		bw.flush();
		bw.close();
		br.close();
	}// main

	public static void comb(int n, int r) {
		// 1.종료조건
		if (r == 0) {
			int[] tmp = Arrays.copyOf(sel, R);
			result.add(tmp);
			return;
		} else if (n<r) {
			return;
		} else {
			sel[r - 1] = data[n - 1];
			comb(n-1, r - 1);
			comb(n - 1, r);
		}

	}

}
