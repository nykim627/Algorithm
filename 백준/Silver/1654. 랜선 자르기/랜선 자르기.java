import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        int maxLen = 0;
        for(int i=0;i<k;i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	maxLen = Math.max(maxLen, arr[i]);
        }
        
        long left = 1;
        long right = maxLen; //어떤 랜선도 자기 자신보다 길게 자를 수 없음
        long ans = 0;
        while(left<=right) {
        	long mid = (left+right)/2; //범위 초과 주의 -> long
        	int cnt = 0;
        	for(int i=0;i<k;i++) {
        		cnt += arr[i]/mid;
        	}
        	if(cnt>=n) {
        		ans = mid;
        		left = mid+1;
        	}
        	else right = mid-1;
        }

        System.out.println(ans);
    }
}