import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            p = new int[n+1];
            for(int i=1;i<=n;i++){
                p[i] = i; //makeset
            }

            System.out.print("#"+tc+" ");

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(order==0){
                    int px = findset(a);
                    int py = findset(b);
                    union(px,py);
                }else{
                    System.out.print(findset(a)==findset(b) ? 1 : 0);
                }
            }

            System.out.println();
        }//tc순회
    }//main

    static void union(int x, int y){
        p[y] = x;
    }

    static int findset(int x){
        if(p[x] != x) p[x] = findset(p[x]);
        return p[x];
    }
}
