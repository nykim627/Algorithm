import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //양의정수
        int k = Integer.parseInt(st.nextToken()); //양의정수 
        
        int[] cnt = new int[n+1];
        int num = 0;
        
        for(int i=1;i<=n;i++) {
        	if(n%i==0) {
        		cnt[i]++;
        		num++;
        	}
        }
        
        if(num<k) {
        	System.out.println(0);
        }else {
        	for(int i=1;i<=n;i++) {
        		if(cnt[i]>0) {
        			k--;
        			if(k==0) {
        				System.out.println(i);
        			}
        		}
        	}
        }


    }
}