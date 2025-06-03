import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //양의정수
        int b = Integer.parseInt(st.nextToken()); //양의정수 (두 수가 같은 경우는 없다)
        String res = "";
        while(!(a==0&&b==0)) {
        	if(a/b>=1&&a%b==0) {
        		res = "multiple";
        	}else if(b/a>=1&&b%a==0) {
        		res = "factor";
        	}else {
        		res = "neither";
        	}
        		
        	System.out.println(res);
        	
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        }

    }
}