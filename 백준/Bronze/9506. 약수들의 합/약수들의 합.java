import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb;
        while(n!=-1) {
        	sb = new StringBuilder();
        	int[] cnt = new int[n];
        	int sum = 0;
        	int num = 0; //약수개수
        	for(int i=1;i<n;i++) {
        		if(n%i==0) {
        			cnt[i]++;
        			sum += i;
        			num++;
        		}
        	}
        	if(sum==n) {
        		sb.append(n).append(" = ");
        		for(int i=1;i<n;i++) {
        			if(cnt[i]>0) {
        				sb.append(i);
        				num--;
            			if(num!=0) {
            				sb.append(" + ");
            			}
        			}
        		}
        	}else {
        		sb.append(n).append(" is NOT perfect.");
        	}
        	System.out.println(sb.toString());
        	
        	n = Integer.parseInt(br.readLine());
        }


    }
}