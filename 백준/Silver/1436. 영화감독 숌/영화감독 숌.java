import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        for(int i=0;i<=6669999;i++) {
        	String str = Integer.toString(i);
        	if(str.contains("666")) {
        		num++;
        		if(num==N) {
        			System.out.println(i);
        			break;
        		}
        	}

        }
        
        
    }
}