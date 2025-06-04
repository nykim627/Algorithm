import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			set.add(tmp);
		}
		
		String[] arr = new String[set.size()];
		int idx = 0;
		for(String e: set) {
			arr[idx++] = e;
		}
		
		Arrays.sort(arr, (cur,pos)->{
			if(cur.length()==pos.length()) return cur.compareTo(pos);
			return cur.length()-pos.length();
		});
		
		for(String e: arr) {
			System.out.println(e);
		}
		
	}
}