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
        
        int res = 1;
        if(a*n0+b > c*n0) {
        	res = 0;
        }else if(a>c) {
        	res = 0;
        }else {
        	res = 1;
        }
        
        System.out.println(res);
    }
}