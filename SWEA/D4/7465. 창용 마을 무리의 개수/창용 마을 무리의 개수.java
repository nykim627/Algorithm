import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            p = new int[n+1];
            for(int i=1;i<=n;i++){
                p[i] = i; //makeset
            }
            sb.append("#").append(tc).append(" ");

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int px = findset(a);
                int py = findset(b);
                union(px,py);
            }

            int[] count = new int[n+1];
            for(int i=1;i<=n;i++){
                count[findset(i)]++; //i의 대표자를 센다.
            }

            int cnt = 0; //무리 개수
            for(int i=1;i<=n;i++){
                if(count[i]!=0) cnt++;
            }

            sb.append(cnt).append("\n");
        }//tc순회
        System.out.println(sb.toString());
    }//main

    static void union(int x, int y){
        p[y] = x;
    }

    static int findset(int x){
        if(p[x] != x) p[x] = findset(p[x]);
        return p[x];
    }
}
