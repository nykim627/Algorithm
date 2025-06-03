import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        int num = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=a;i<=b;i++) {
        	boolean isPrime = true;
        	if(i==1) isPrime = false;
        	else {
            	for(int j=2;j<i;j++) {
            		if(i%j==0) {
            			isPrime = false;
            			break;
            		}
            	}
        	}

        	if(isPrime) {
        		num++;
        		min = Math.min(min, i);
        		sum += i;
        	}
        }
        
        if(num==0) {
        	System.out.println(-1);
        }else {
        	System.out.println(sum);
        	System.out.println(min);
        }

    }
}