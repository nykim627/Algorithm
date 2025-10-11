import java.util.*;
import java.io.*;

class Main{
    static class Person{
        int w, h;
        Person(int w, int h){
            this.w = w;
            this.h = h;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] arr = new Person[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i] = new Person(w,h);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){ //me
            int rank = 1;
            for(int j=0;j<N;j++){ //you
                if(i==j) continue;
                if(arr[i].w < arr[j].w && arr[i].h < arr[j].h) rank++;
            }
            sb.append(rank).append(" ");
        }
        
        System.out.println(sb.toString());
    }
    
}