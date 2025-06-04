import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//사용자 정의 정렬 순으로 집합 생성됨
		TreeSet<String> set = new TreeSet<>((o1, o2)->{
			return o2.compareTo(o1);
		});
		
		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split(" ");
			if(tmp[1].equals("enter")) {
				set.add(tmp[0]);
			}else if(tmp[1].equals("leave")) {
				set.remove(tmp[0]);
			}
		}
		
		for(String e: set) {
			System.out.println(e);
		}
		
		
	}
}