import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //양의정수
        int b = Integer.parseInt(st.nextToken()); //양의정수
        int c = Integer.parseInt(st.nextToken()); //양의정수
        int max = Math.max(a, Math.max(b,c));
        
        int res = 0;
        if(max >= a+b+c-max) {
        	res = (a+b+c-max)*2 - 1;
        }else {
        	res = a+b+c;
        }
        
        System.out.println(res);
    }
}