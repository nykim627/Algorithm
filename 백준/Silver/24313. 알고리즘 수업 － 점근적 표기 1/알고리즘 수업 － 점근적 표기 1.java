import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        
        int res = 0;
        if(c-a==0) {
        	if(b<=0) {
        		res = 1;
        	}
        }else if(c-a>0) {
        	if(b<=0) {
        		res = 1;
        	}else {
        		if(b/(c-a)<=n0) {
        			res = 1;
        		}
        	}
        }
        
        System.out.println(res);
    }
}