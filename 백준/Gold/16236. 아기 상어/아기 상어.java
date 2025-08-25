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
        Queue<int[]> tmpQ = new LinkedList<>();
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        tmpQ.add(new int[]{state.x,state.y});
        int[][] visited = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i], -1);
        }
        visited[state.x][state.y] = 0;

        while(!tmpQ.isEmpty()){
            int[] curr = tmpQ.poll();
            //물고기가 있고 상어크기보다 작으면 먹을 수 있으므로 해당 칸 리턴
            if(map[curr[0]][curr[1]]>0 && map[curr[0]][curr[1]]<state.size) {
//                System.out.println("먹을 수 있는 물고기 위치: "+curr[0]+" "+curr[1]);
//                System.out.println("거리: "+visited[curr[0]][curr[1]]);
                pq.offer(new Pos(curr[0], curr[1], visited[curr[0]][curr[1]]));
            }
            for(int d=0;d<4;d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr>=N||nc>=N||nr<0||nc<0) continue; //범위 초과 주의
                if(map[nr][nc]>state.size) continue; //상어크기보다 작은 물고기가 있는 칸은 접근 불가
                if(visited[nr][nc]!=-1) continue; //방문한 칸은 패스
                visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
//                System.out.println("nr&nc: "+nr+" "+nc);
                tmpQ.offer(new int[]{nr,nc});
            }
        }
        if(pq.isEmpty()){
            //먹을 수 있는 물고기가 있는 칸 없음
            return new Pos(-1,-1,-1); //x=-1,y=-1,dist=-1
        }else{
            //있으면 거리 짤음 -> 가장 위 -> 가장 왼쪽 순으로 가장 먼저 있는 칸을 선택
            return pq.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); //공간의 크기 n
        map = new int[N][N];

        //변경되는 상어 위치 넣을 큐
        Queue<State> q = new LinkedList<>();
        //map 채우기
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) q.add(new State(i,j,2,0));
            }
        }

        //상어위치 바뀌지 않을때까지 반복
        int totalTime = 0; //총시간
        while(!q.isEmpty()){
            State curr = q.poll();
            Pos res = check(curr); //먹을 수 있는 물고기 있는지 췤
            if(res.x==-1&&res.y==-1&&res.dist==-1) break; //먹을 수 있는 물고기 없음.
            totalTime += res.dist; //먹을 수 있는 물고기까지의 거리를 총시간에 더하기
            map[res.x][res.y] = 9; //물고기 없어진 위치의 값을 상어 위치인 9으로 변경
            map[curr.x][curr.y] = 0; //기존 상어 위치를 0으로 변경
            curr.cnt++; //상어가 먹은 물고기 수 +1 증가
            if(curr.cnt==curr.size){
                curr.size++; //상어크기 +1 하고
                curr.cnt = 0;  //상어가 먹은 물고기 수 초기화 (이건 체크해봐야함)
            }
//            System.out.println("상어 크기: "+curr.size+" & 상어가 먹은 물고기수: "+curr.cnt);
//            for(int i=0;i<N;i++){
//                System.out.println(Arrays.toString(map[i]));
//            }
            q.offer(new State(res.x,res.y,curr.size,curr.cnt)); //새 상어 상태 큐에 넣음
        }

        sb.append(totalTime);
        System.out.println(sb.toString());

    }
}