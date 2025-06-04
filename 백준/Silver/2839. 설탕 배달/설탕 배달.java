import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        
        int min = Integer.MAX_VALUE; //최소봉지개수
        boolean isAvailable = false;
        
        int share = N/5;
        for(int i=0;i<=share;i++) {
        	int remainder = N - 5*i;
        	num = i;
        	if(remainder%3==0) {
        		num += remainder/3;
        		min = Math.min(min,  num);
        		isAvailable = true;
        	}
        }

        if(isAvailable) {
        	System.out.println(min);        	
        }else {
        	System.out.println(-1);
        }
        
    }
}