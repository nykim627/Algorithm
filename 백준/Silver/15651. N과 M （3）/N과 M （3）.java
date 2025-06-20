import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int N, M;
	static ArrayList<int[]> arrList;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arrList = new ArrayList();
		res = new int[M];
		permperm(0);
		
		for(int[] e1: arrList) {
			for(int e2: e1) {
				sb.append(e2).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void permperm(int idx) {
		if(idx==M) {
			arrList.add(Arrays.copyOf(res, M));
			return;
		}
		
		for(int i=1;i<=N;i++) { //중복순열이므로 방문배열필요x
			res[idx] = i;
			permperm(idx+1);
		}
	}
	
}
