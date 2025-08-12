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
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left=0;
        int right=0;
        int minLen = 100000;
        int sum = arr[left];
        while(left<=right&&right<n) {
        	if(sum>=s) {
        		minLen = Math.min(minLen, right-left+1);
        		sum-=arr[left++];
        	}else {
        		right++;
        		if(right>=n) break; //범위초과 주의
        		else sum+=arr[right]; 
        	}
        }
        
        if(minLen==100000) minLen = 0; //합을 만드는 것이 불가능하다면 0을 출력
        
        System.out.println(minLen);
    }
}