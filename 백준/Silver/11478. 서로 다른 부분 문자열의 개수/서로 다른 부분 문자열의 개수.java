import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<sb.length();i++) {
			for(int j=i+1;j<=sb.length();j++) {
				set.add(sb.substring(i,j));
			}
		}
		
//		for(String e:set) {
//			System.out.println(e);
//		}
		
		System.out.println(set.size());
		
	}
}