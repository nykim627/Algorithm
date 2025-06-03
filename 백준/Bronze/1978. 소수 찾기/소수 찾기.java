import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        int num = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int tc=0;tc<T;tc++) {
        	int N = Integer.parseInt(st.nextToken());
        	boolean isOk = true;
        	if(N==1) { //1은 소수아님 
        		isOk = false;
        	}else {
            	for(int i=2;i<N;i++) {
            		if(N%i==0) {
            			isOk = false;
            			break;
            		}
            	}
        	}
        	//소수인 애들만 세기
        	if(isOk) {
        		num++;
        	}
        }
        
        System.out.println(num);


    }
}