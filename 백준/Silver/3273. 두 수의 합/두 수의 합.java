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
        Arrays.sort(arr); //정렬 후 투포인터(양끝부터)
        
        int x = Integer.parseInt(br.readLine());
        
        int start = 0;
        int end = n-1;
        int cnt = 0;
        while(start<end) {
        	if(arr[start]+arr[end]==x) {
        		start++;
        		end--;
        		cnt++;
        	} else if(arr[start]+arr[end]<x) {
        		start++;
        	} else end--;
        }
        

        System.out.println(cnt);
    }
}