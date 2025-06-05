import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.keySet().contains(tmp)) {
				int val = map.get(tmp);
				map.put(tmp, ++val);
			}else {
				map.put(tmp, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.keySet().contains(tmp)) {
				sb.append(map.get(tmp)).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb.toString());
		
	}
}