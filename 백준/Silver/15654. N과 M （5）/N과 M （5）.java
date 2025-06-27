import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, M;
	static int[] sel, arr;
	static ArrayList<int[]> arrList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sel = new int[M];
		visited = new boolean[N];
		arrList = new ArrayList<int[]>();
		perm(0);
		
		for(int[] e1: arrList) {
			for(int e2: e1) {
				sb.append(e2).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
	
	private static void perm(int idx) {
		if(idx==M) {
			arrList.add(Arrays.copyOf(sel, M));
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			sel[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
		
	}

}
