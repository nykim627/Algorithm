import java.util.*;
import java.io.*;

class Main{
    static boolean[][] map;
    static int N, num; //단지번호
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j)=='0' ? false : true;
            }
        }
        
        num = 1;
        visited = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]&&visited[i][j]==0) bfs(i,j,num++);
            }
        }
        
        num--; //마지막에 하나 더 올라가서 낮춰줌
        int[] cnt = new int[num+1]; //각 단지번호당 세대수
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]>0) cnt[visited[i][j]]++;
            }
        }
        Arrays.sort(cnt);
        sb.append(num).append("\n");
        for(int i=1;i<=num;i++){
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void bfs(int r, int c, int num){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = num;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];
                if(nr<0||nc<0||nr>=N||nc>=N) continue;
                if(!map[nr][nc]) continue;
                if(visited[nr][nc]!=0) continue;
                visited[nr][nc] = num;
                q.add(new int[]{nr,nc});
            }
        }
    }
}