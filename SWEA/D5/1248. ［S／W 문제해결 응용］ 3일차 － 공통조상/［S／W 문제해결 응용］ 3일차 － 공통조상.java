import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static int[][] tree;
	static int subTreeSize = 0; //서브트리 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // tc수

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 정점의 개수
			int e = Integer.parseInt(st.nextToken()); // 간선의 개수 (=v-1)
			int a = Integer.parseInt(st.nextToken()); // 공통 조상을 찾는 정점 번호 1
			int b = Integer.parseInt(st.nextToken()); // 공통 조상을 찾는 정점 번호 2

			// 트리 구조 파악하기
			tree = new int[v + 1][3]; // 행: 정점번호, 열: [0]왼자, [1]오자, [2]부모

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int p = Integer.parseInt(st.nextToken()); // 부모
				int c = Integer.parseInt(st.nextToken()); // 자식
				if (tree[p][0] == 0) { // 왼자가 아직 채워지지 않았다면
					tree[p][0] = c; // 왼자로 저장
				} else {
					tree[p][1] = c; // 아니면 오자로 저장
				}
				tree[c][2] = p; // 부모저장
			}

			// 정점마다 정보 확인
//			for(int i=0; i<v+1; i++) {
//				System.out.println(i + " : " + Arrays.toString(tree[i]));
//			}
			
//			boolean[] visit = new boolean[v+1];
//			
//			visit[5] = true;
//			
//			if (visit[i]) {
//				return i;
//			}

			// 공통 조상 찾기 => 재귀로 만들수 있나...?
			int[] cnt = new int[v + 1]; // 정점 방문여부 저장 배열
			// a의 조상 찾기
			int ap = tree[a][2]; // a의 부모
			while (ap != 0) { // 부모 값이 없을때까지(루트노드일때까지)
				cnt[ap]++;
				a = ap; //a의 부모가 이제 새로운 a가 된다!
				ap = tree[a][2]; //새로운 a의 부모를 찾는다!
			}
			// b의 조상 찾다가 이미 방문된 노드 만나면 그 노드 번호가 가장 가까운 공통 조상
			int bp = tree[b][2]; // b의 부모
			int cp = 0; // common parent. 가장 가까운 공통 조상
			while (bp != 0) { // 부모 값이 없을때까지(루트노드일때까지)
				if (cnt[bp] == 1) {
					cp = bp;
					break;
				} else {
					cnt[bp]++;
					b = bp; //b의 부모가 이제 새로운 b가 된다!
					bp = tree[b][2]; //새로운 b의 부모를 찾는다!
				}
			}
			
			//공통 조상을 루트로 하는 서브 트리의 크기 알아내기 => 중위 순회 이용!(종류는 상관x)
			subTreeSize = 0; //서브트리 크기 초기화
			inOrder(cp);
			System.out.println("#"+tc+" "+cp+" "+subTreeSize);
			
			

//			sb.append("\n"); // 개행문자 추가
//			bw.write(sb.toString()); // 최종결과출력

		} // tc순회 끝
//
//		bw.flush();
//		br.close();
//		bw.close();
	}
	
	public static void inOrder(int v) {
		//v라는 노드의 번호가 유효한지 확인
		if(v<tree.length && v!=0) {  //재귀탈출조건: 기존 트리의 마지막 정점번호보다 작아야함!
			//왼쪽자식탐방
			inOrder(tree[v][0]);
			//서브트리 개수 +1
			subTreeSize++;
			//오자탐방
			inOrder(tree[v][1]);
		}
	}
	
	

}