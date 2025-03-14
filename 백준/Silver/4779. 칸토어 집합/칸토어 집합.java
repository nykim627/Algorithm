
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int N;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            sb = new StringBuilder();
            String tmp = br.readLine();
            if(tmp==null || tmp.isEmpty()){
                break;
            }
            N = Integer.parseInt(tmp);
            len = (int)Math.pow(3,N);
            for(int i=0;i<len;i++){
                sb.append("-");
            }
//            System.out.println("before divideConquer: "+sb.toString());

            divideConquer(0,len-1);
//            System.out.println("after divideConquer: "+sb.toString());
            System.out.println(sb.toString());

        }
    }//main

    static void divideConquer(int start, int end){
        int len = end - start + 1;
        if (len < 3) {
            return;
        }

        int midStart = start + len / 3;
        int midEnd = start + len / 3 * 2;

        for (int i = midStart; i < midEnd; i++) {
            sb.setCharAt(i, ' ');  // replace 대신 setCharAt 사용
        }

        divideConquer(start, midStart - 1);
        divideConquer(midEnd, end);

    }
}
