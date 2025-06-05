import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> arrList = new ArrayList();
		for(int i=0;i<M;i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)) {
				arrList.add(tmp);
			}
		}
		
		Collections.sort(arrList);
		
		System.out.println(arrList.size());
		for(String e: arrList) {
			System.out.println(e);
		}
		
	}
}