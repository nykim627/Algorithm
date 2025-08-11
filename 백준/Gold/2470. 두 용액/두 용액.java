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
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = n-1;
        int target = 0;
        int[] ansIdx = new int[2];
        int ansVal = Integer.MAX_VALUE;
        while(left<right) {
        	int sum = arr[left]+arr[right];
//        	System.out.println(sum);
        	if(sum>target) {
        		if(ansVal > sum-target) {
        			ansVal = sum-target;
        			ansIdx = new int[] {arr[left], arr[right]};
        		}
        		right--;
        	}
        	else if(sum<target) {
        		if(ansVal > target-sum) {
        			ansVal = target-sum;
        			ansIdx = new int[] {arr[left], arr[right]};
        		}
        		left++;
        	}
        	else {
        		ansVal = target-sum;
        		ansIdx = new int[] {arr[left], arr[right]};
        		break;
        	};
        }
        
        System.out.println(ansIdx[0]+" "+ansIdx[1]);
    }
}