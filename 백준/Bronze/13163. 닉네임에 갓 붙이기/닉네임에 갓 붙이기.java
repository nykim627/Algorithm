import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder("god");
            for(int j=1;j<str.length;j++){
                sb.append(str[j]);
            }
            System.out.println(sb.toString());
        }
    }
}