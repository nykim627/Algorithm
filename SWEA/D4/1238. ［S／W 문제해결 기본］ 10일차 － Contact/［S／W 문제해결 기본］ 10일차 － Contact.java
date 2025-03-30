import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    static int N; //섬의 개수
    static List<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){
            sb.append("#").append(tc).append(" ");
            //입력받기 시작
            st = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(st.nextToken()); //간선개수
            int start = Integer.parseInt(st.nextToken()); //시작점
            int[] fromArr = new int[E/2];
            int[] toArr = new int[E/2];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<E/2;i++){
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                fromArr[i] = f; toArr[i] = t;
            }//입력 끝!

            adj = new ArrayList[101];
            for(int i=1;i<=100;i++){
                adj[i] = new ArrayList<>();
            }//초기화

            for(int i=0;i<E/2;i++){
                adj[fromArr[i]].add(toArr[i]); //유향
            }//그래프 표현 끝!

            visited = new int[101];
            int ans = bfs(start);

            sb.append(ans).append("\n");

        }//tc끝

        System.out.println(sb.toString());

    }//main

    static int bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v]++;

        int maxDepth = 0;
        int maxNumatDepth = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int e: adj[curr]){
                if(visited[e] == 0){
                    visited[e] = visited[curr]+1;
                    q.add(e);
                    if(visited[e]>maxDepth){
                        maxDepth = visited[e];
                        maxNumatDepth = e;
                    }else if(visited[e]==maxDepth){
                        maxNumatDepth = Math.max(maxNumatDepth,e);
                    }
                }
            }
        }
        return maxNumatDepth;
    }//bfs

}
