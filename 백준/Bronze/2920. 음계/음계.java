import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean asc = true;
        boolean desc = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for(int i=0;i<7;i++){
            int curr = Integer.parseInt(st.nextToken());
            if(prev<curr) desc = false;
            if(prev>curr) asc = false;
            prev = curr;
        }
        if(desc) System.out.println("descending");
        else if(asc) System.out.println("ascending");
        else System.out.println("mixed");
    }
}