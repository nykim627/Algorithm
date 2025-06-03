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
        
        String res ="";
        while(!(a==0&&b==0&&c==0)){
            if(max >= (a+b+c-max)){
                res = "Invalid";
            }else if(a==b && b==c){
                res = "Equilateral";
            }else if(a!=b && b!=c && c!=a){
                res = "Scalene";
            }else{
                res = "Isosceles";
            }
            
            System.out.println(res);
            
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            max = Math.max(a, Math.max(b,c));
        }
        
        
    }
}