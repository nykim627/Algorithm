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
		comb(0,1);
		
		for(int[] e1: arrList) {
			for(int e2: e1) {
				sb.append(e2).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
    //전형적인 조합
	public static void comb(int idx, int start) {
		if(idx==M) {
			arrList.add(Arrays.copyOf(res, M));
			return;
		}
		
		for(int i=start;i<=N;i++) { //시작점을 제한하므로 방문배열 필요x
			res[idx] = i;
			comb(idx+1,i+1);
		}
	}
	
}
