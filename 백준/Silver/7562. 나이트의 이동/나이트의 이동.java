import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int L;
//    static int[][] map;
    static int[][] visited;
    static int[] dr = {1,2,2,1,-1,-2,-2,-1};
    static int[] dc = {-2,-1,1,2,-2,-1,1,2};
    static int[] start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++){
            L = Integer.parseInt(br.readLine());
            start = new int[2];
            end = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            visited = new int[L][L];
            int res = bfs(start, end);
            sb.append(res).append("\n");

        }//tc

        System.out.println(sb.toString());
    }

    static int bfs(int[] start, int[] end){
        Queue<int[]> q = new LinkedList();
        q.add(start);
        visited[start[0]][start[1]] = 1; //시작점 거리를 1로 지정했으므로 마지막에 1빼야함!

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==end[0]&&curr[1]==end[1]) return visited[end[0]][end[1]]-1;
            for(int d=0;d<8;d++){
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr<0||nc<0||nr>=L||nc>=L) continue;
                if(visited[nr][nc]!=0) continue;
                visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
                q.add(new int[]{nr,nc});
            }
        }

        return 0;
    }



}

