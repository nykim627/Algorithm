import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int visited; //방문표시 위한 2진수
    static int[] sel;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[M]; //뽑은 M개 수 저장
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        sb = new StringBuilder();
        comb(0,0);
        System.out.println(sb.toString());

        br.close();
    }//main

    static void comb(int n, int m){
        if(m==M){ //sel에 M개 수 다 채워지면 출력
            for(int e: sel){
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=n;i<N;i++){
            sel[m] = i+1;
            comb(i+1, m+1);
        }


    }

}
