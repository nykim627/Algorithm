import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int[] count = new int[max+1];
		for(int i=0;i<N;i++) {
			count[arr[i]]++;
		}
		
		for(int i=1;i<max+1;i++) {
			count[i] += count[i-1];
		}
		
		int[] res = new int[N];
		for(int i=N-1;i>=0;i--) {
			res[--count[arr[i]]] = arr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int e: res) {
			sb.append(e).append("\n");
		}
		
		System.out.println(sb.toString());

	}
}