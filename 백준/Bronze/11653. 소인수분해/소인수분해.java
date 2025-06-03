import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int k = 2;
        while(n!=1) {
        	if(n%k==0) {
        		n /= k;
        		System.out.println(k);
        	}else {
        		k++;
        	}
        }
    }
}