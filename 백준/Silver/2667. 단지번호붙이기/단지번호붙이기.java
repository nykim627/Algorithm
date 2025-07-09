import java.util.*;
import java.io.*;

public class Main
{
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N;
    static int[][] map;
    static int cnt; //총 단지수
    static int subcnt; //단지 당 세대수
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<N;j++){
                int tmp = row.charAt(j) - '0';
                map[i][j] = tmp;
            }
        }

        ArrayList<Integer> arrList = new ArrayList();
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0 || visited[i][j]) continue;
                dfs(i,j);
                cnt++; 
                arrList.add(subcnt);
                subcnt = 0; //단지 당 세대수 초기화
            }
        }
        
        Collections.sort(arrList);
        
        System.out.println(cnt);
        for(int e: arrList) {
        	System.out.println(e);
        }
        
    }

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		subcnt++;
		
		for(int d=0;d<4;d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc]==0) continue;
			dfs(nr,nc);
		}
	}
}