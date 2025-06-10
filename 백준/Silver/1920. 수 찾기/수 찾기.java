import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int num=0;
	static int[] order;
	static ArrayList<Integer>[] arrList;
	static int V, E, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int res = binarySearch(arr, Integer.parseInt(st.nextToken()));
			sb.append(res).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int binarySearch(int[] arr, int k) {
		int left = 0;
		int right = arr.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(k==arr[mid]) {
				return 1;
			}else if(k<arr[mid]) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		return 0;
	}

}
