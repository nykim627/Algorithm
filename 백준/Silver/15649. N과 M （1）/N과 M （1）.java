import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1]; //N까지의 자연수에 대한 방문배열
        sel = new int[M]; //뽑은 M개 수 저장
        perm(0);
        bw.flush();
        bw.close();
        br.close();
    }//main

    static void perm(int m){
        if(m==M){ //sel에 M개 수 다 채워지면 출력
            for(int e: sel){
                System.out.print(e+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){ //해당 자연수 안골랐으면
                visited[i]=true; //고르고
                sel[m] = i; //m번째 수로 저장
                perm(m+1); //그 다음 수 고르러 ㄱㄱ
                visited[i] = false; //백트래킹 위해 다시 안고른척~
            }
        }


    }

}
