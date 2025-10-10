import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            q.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            //k-1번 회전
            for(int j=1;j<K;j++){
                q.add(q.poll());
            }
            //k번째 사람 제거
            int dead = q.poll();
            sb.append(dead);
            if(q.isEmpty()){
                sb.append(">");
            }else{
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}