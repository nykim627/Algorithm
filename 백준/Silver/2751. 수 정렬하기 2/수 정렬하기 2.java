import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList();
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(br.readLine());
			list.add(tmp);
		}
		
		//Arrays.sort는 최악의 경우 O(n^2)이므로 에러남
		//Collections.sort는 최악, 평균 모두 O(nlogn)으로 안정적
		Collections.sort(list, (cur, pos)->{
			return cur-pos;
		});

		StringBuilder sb = new StringBuilder();
		for(int e: list) {
			sb.append(e).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}