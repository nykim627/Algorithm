import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String name = br.readLine();
			map1.put(i, name);
			map2.put(name, i);
			
		}
		
		for(int i=0;i<M;i++) {
			String tmp = br.readLine();
			if(Character.isDigit(tmp.charAt(0))) {
				sb.append(map1.get(Integer.parseInt(tmp))).append("\n");
			}else {
				sb.append(map2.get(tmp)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
}