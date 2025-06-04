import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		
		int sum = 0;
		for(int i=0;i<5;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += (int) Math.pow(arr[i], 2);
		}
		
		System.out.println(sum%10);
		
	}
}