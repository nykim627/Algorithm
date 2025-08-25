import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int[] dr = {-1,0,0,1}; //상 좌 우 하 : 가장 위 -> 가장 왼쪽
    static int[] dc = {0,-1,1,0};

    //아기상어의 상태
    static class State{
        int x, y, size, cnt; //x위치,y위치,상어크기,먹은 물고기 수
        State(int x,int y, int size, int cnt){
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
        }
    }

    //bfs 칸 상태
    static class Pos implements Comparable<Pos>{
        int x, y, dist;
        Pos(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pos o){
            if(this.dist!=o.dist) return this.dist-o.dist;
            if(this.x!=o.x) return this.x-o.x;
            return this.y-o.y;
        }
    }

    //먹을 수 있는 물고기가 있는 칸인지 체크
    static Pos check(State state){
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        q.add(new int[]{state.x,state.y});
        int[][] visited = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i], -1);
        }
        visited[state.x][state.y] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            //물고기가 있고 상어크기보다 작으면 먹을 수 있으므로 해당 칸 리턴
            if(map[curr[0]][curr[1]]>0 && map[curr[0]][curr[1]]<state.size) {
                pq.offer(new Pos(curr[0], curr[1], visited[curr[0]][curr[1]]));
            }
            for(int d=0;d<4;d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr>=N||nc>=N||nr<0||nc<0) continue; //범위 초과 주의
                if(map[nr][nc]>state.size) continue; //상어크기보다 큰 물고기가 있는 칸은 접근 불가
                if(visited[nr][nc]!=-1) continue; //방문한 칸은 패스
                visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
                q.offer(new int[]{nr,nc});
            }
        }
        return pq.isEmpty() ? null : pq.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //공간의 크기 n
        map = new int[N][N];

        State shark = new State(-1,-1,2,0);
        //map 채우기
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    shark.x = i;
                    shark.y = j;
                    map[i][j] = 0; //상어위치는 빈칸으로 놔두고 shark로만 추적
                }
            }
        }

        //상어위치 바뀌지 않을때까지 반복
        int totalTime = 0; //총시간
        while(true){
            Pos res = check(shark); //먹을 수 있는 물고기 있는지 췤
            if(res==null) break; //먹을 수 있는 물고기 없음.
            totalTime += res.dist; //먹을 수 있는 물고기까지의 거리를 총시간에 더하기
            map[res.x][res.y] = 0; //물고기 없어진 위치의 값을 0으로 변경
            shark.cnt++; //상어가 먹은 물고기 수 +1 증가
            if(shark.cnt==shark.size){
                shark.size++; //상어크기 +1 하고
                shark.cnt = 0;  //상어가 먹은 물고기 수 초기화
            }
            //상어 위치 갱신
            shark.x = res.x;
            shark.y = res.y;
        }

        System.out.println(totalTime);

    }
}