import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int N, M;
	static int[] sel; //M개만큼 선택
	static ArrayList<int[]> arrList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		arrList = new ArrayList();
		combcomb(1, 0);
		
		for(int[] e1: arrList) {
			for(int e2: e1) {
				sb.append(e2).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	//중복조합
	static void combcomb(int start, int idx) {
		if(idx==M) {
			arrList.add(Arrays.copyOf(sel, M));
			return;
		}
		
		for(int i=start;i<=N;i++) {
			sel[idx] = i;
			combcomb(i, idx+1);
//			combcomb(i+1, idx+1);
		}
		
	}
	
}
