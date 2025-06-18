import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb;
//	static int[] arr;  //원래 필요하지만 해당 문제에서는 인덱스값이 곧 배열값이므로 생략
	static int[] res;  //결과저장배열
	static boolean[] visited; //기존 arr에 대한 방문배열
	static ArrayList<int[]> arrList; //전체결과 저장 배열리스트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		arr = new int[N+1];
		visited = new boolean[N+1];
		res = new int[M];
		arrList = new ArrayList();
//		for(int i=1;i<=N;i++) {
//			arr[i] = i;
//		}		
		
		perm(0); //index 0부터 결과저장
		
		for(int[] e1: arrList) {
			for(int e2: e1) {
				sb.append(e2).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	//수열(뽑는순서 상관o)
	static void perm(int idx) {  
		
		if(idx==M) {
			arrList.add(Arrays.copyOfRange(res, 0, M)); //깊은복사해야함
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue;
            res[idx] = i;   //또는 arr[i]
			visited[i] = true; //사용하지 않은 원소에 대해 사용후 방문처리 
			perm(idx+1);  //res의 다음 인덱스값에 대한 처리
			visited[i] = false;   //백트래킹: 현재 상태로 되돌아가서 다른 가능성을 탐색
		}
	}
	
}
