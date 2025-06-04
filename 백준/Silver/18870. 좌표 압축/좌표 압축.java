import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] tmp = new int[N];
		HashSet<Integer> set = new HashSet(); //set으로 중복제거
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			tmp[i] = num;
			set.add(num);
		}
		
		Integer[] arr = set.toArray(new Integer[0]);
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int e: tmp) {
			sb.append(Arrays.binarySearch(arr, e)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}