import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] arrList;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        arrList = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	arrList[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arrList[a].add(b);
        }
        
        dist = new int[N+1];
        Arrays.fill(dist,  -1);
        bfs(X);
        
        boolean noCity = false;
        for(int i=1;i<=N;i++) {
        	if(dist[i]==K) {
        		System.out.println(i);
        		noCity = true;
        	}
        }
        if(!noCity) System.out.println(-1);
    }
    
    public static void bfs(int start) {
    	Queue<Integer> q = new ArrayDeque<>();
    	q.add(start);
    	dist[start] = 0;
    	
    	while(!q.isEmpty()) {
    		int curr = q.poll();
    		for(int e: arrList[curr]) {
    			if(dist[e]>=0) continue;
    			dist[e] = dist[curr]+1;
    			q.add(e);
    		}
    	}
    }
}