import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int N, M;
    static boolean[][] map;
    static int[][] visited; //방문배열이자 거리배열
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new int[N][M];
        for(int r=0;r<N;r++){
            String str = br.readLine();
            for(int c=0;c<M;c++){
                map[r][c] = (str.charAt(c) - '0')!=0;
            }
        }

        bfs(0,0);

        System.out.println(visited[N-1][M-1]);
    }

    static void bfs(int r, int c){
        Queue<int[]> q =  new LinkedList<int[]>();
        q.add(new int[]{r,c});
        visited[r][c] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==N-1&&curr[1]==M-1){
                return;
            }
            for(int d=0;d<4;d++){
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(!map[nr][nc] || visited[nr][nc]!=0) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = visited[curr[0]][curr[1]]+1;
            }
        }

    }


}

