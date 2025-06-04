import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet(); //set으로 중복제거
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(set.contains(tmp)) sb.append(1).append(" ");
			else sb.append(0).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
	}
}