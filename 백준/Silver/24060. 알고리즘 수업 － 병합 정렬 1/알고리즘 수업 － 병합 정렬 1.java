import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static int[] tmp; //임시저장 배열
	static int[] arr;
	static int K;
	static int savedCnt = 0; 
	static int ans = -1; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		merge_sort(0, N-1);
		
		sb.append(ans).append("\n");
		
		System.out.println(sb.toString());
		
	}


	private static void merge_sort(int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			merge_sort(start,mid);
			merge_sort(mid+1,end);
			merge(arr, start, mid, end);
		}
	}


	private static void merge(int[] arr, int start, int mid, int end) {
		int L = start;
		int R = mid+1;
		
		int idx = start;
		
		while(L<=mid && R<=end) {
			if(arr[L]<=arr[R]) {
				savedCnt++;
				if (savedCnt == K) ans = arr[L];
				tmp[idx++] = arr[L++];
			}else {
				savedCnt++;
				if (savedCnt == K) ans = arr[R];
				tmp[idx++] = arr[R++];
			}
		}
		
		if(L<=mid) {
			for(int i=L;i<=mid;i++) {
				savedCnt++;
				if (savedCnt == K) ans = arr[i];
				tmp[idx++] = arr[i];
			}
		}else {
			for(int i=R;i<=end;i++) {
				savedCnt++;
				if (savedCnt == K) ans = arr[i];
				tmp[idx++] = arr[i];
			}
		}
		
		for(int i=start;i<=end;i++) {
			arr[i] = tmp[i];
		}
		
	}
	
	
}
