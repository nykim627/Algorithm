import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); //분해합
        int sum = 0;
        int num = 0;
        for(int i=1;i<N;i++) {
        	sum = i;
        	int tmp = i;
        	while(tmp!=0) {
        		sum += tmp%10;
        		tmp /= 10;
        	}
        	if(sum==N) {
        		num = i;
        		break;
        	}
        }
        
        System.out.println(num);
    }
}