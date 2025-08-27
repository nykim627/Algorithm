import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int ans = 0;
    static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1}; //"1"부터 순서대로 ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int[] dc = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static class Fish{
        int r, c, dir;
        boolean alive;
        Fish(int r, int c, int dir, boolean alive){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.alive = alive;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[4][4];
        Fish[] fish = new Fish[17]; //1~16번

        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                fish[num] = new Fish(i, j, dir, true);
            }
        }

        dfs(board, fish, 0, 0, 0);

        System.out.println(ans);

    }

    private static void dfs(int[][] board, Fish[] fish, int sr, int sc, int sum) {
        //깊은 복사
        int[][] b = new int[4][4];
        Fish[] f = new Fish[17];
        for(int i=0;i<4;i++){
            b[i] = board[i].clone();
        }
        for(int i=1;i<=16;i++) f[i] = new Fish(fish[i].r, fish[i].c, fish[i].dir, fish[i].alive);

        //1) 상어가 물고기 먹어
        int eat = board[sr][sc];
        int sdir = 0; //상어 방향
        if(eat>0){ //물고기가 있으면 먹고 물고기 방향이 상어방향됨
            sdir = f[eat].dir;
            f[eat].alive = false; //물고기 죽음ㅠ
            sum += eat; //상어가 먹은 물고기 번호 합 갱신
            b[sr][sc] = -1; //해당 위치를 상어위치로 바꿔줌
        }
        ans = Math.max(ans, sum); //상어가 물고기 먹을 때마다 최종 ans 갱신

        //2) 물고기 이동해
        moveFish(b, f, sr, sc);

        //3) 상어 이동 가능한 위치 파악 (분기)
        for(int step=1;step<=3;step++){
            int nr = sr + dr[sdir]*step;
            int nc = sc + dc[sdir]*step;
            if(outOfRange(nr,nc)) break;
            if(b[nr][nc]<=0) continue; //빈칸 or 상어면 다음 뎁스로

            int tmp = b[sr][sc];
            b[sr][sc] = 0; //상어가 떠날 자리 빈칸으로 변경
            dfs(b,f,nr,nc,sum);
            b[sr][sc] = tmp; //롤백
        }
    }

    public static void moveFish(int[][] board, Fish[] fish, int sr, int sc){
        for(int i=1;i<=16;i++){
            Fish curr = fish[i];
            if(!curr.alive) continue; //해당 번호 물고기 먹혔으면 패스
            for(int rot=0;rot<8;rot++){
                int nr = curr.r + dr[curr.dir];
                int nc = curr.c + dc[curr.dir];
                //범위초과 or 상어위치면 방향 바꿈
                if(outOfRange(nr,nc) || (nr==sr&&nc==sc)){
                    curr.dir = curr.dir==8 ? 1 : curr.dir+1;
                    continue;
                }
                //물고기 이동 1) 번호 swap
                int tmp = board[nr][nc]; //다음 칸 물고기 번호 (0으로 없을수도)
                int num = board[curr.r][curr.c]; //현재 칸 물고기 번호
                board[nr][nc] = num;
                board[curr.r][curr.c] = tmp;
                //물고기 이동 2) 물고기 위치 swap
                if(tmp>0){ //다음칸에 쿨고기 있으면 바꿔줌
                    fish[tmp].r = curr.r;
                    fish[tmp].c = curr.c;
                }
                //현재칸 물고기 위치는 무조건 바꿔야함
                fish[num].r = nr;
                fish[num].c = nc;
                break; //물고기 이동했으면 바로 rotate for문 빠져나오기
            }
        }
    }

    public static boolean outOfRange(int nr, int nc){
        if(nr>=4||nc>=4||nr<0||nc<0) return true;
        return false;
    }

}