//문제번호: 14696
//메모리: 
//시간: 

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] cntA = new int[5];
        int[] cntB = new int[5];

        for(int i=0;i<n;i++){
            cntA = new int[5];
            cntB = new int[5];

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for(int j=0;j<a;j++){
                cntA[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for(int j=0;j<b;j++){
                cntB[Integer.parseInt(st.nextToken())]++;
            }

//            System.out.println(Arrays.toString(cntA));
//            System.out.println(Arrays.toString(cntB));

            boolean hasResult = false;
            for(int j=4;j>0;j--){
                if(cntA[j]>cntB[j]){
                    bw.write("A\n");
                    hasResult = true;
                    break;
                }else if(cntA[j]<cntB[j]){
                    bw.write("B\n");
                    hasResult = true;
                    break;
                }
            }
            if(!hasResult){
                bw.write("D\n");
            }

        }


        bw.flush();
        bw.close();
        br.close();
    }
}
