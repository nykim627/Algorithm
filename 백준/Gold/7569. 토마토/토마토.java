import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] boxes;
    static int[][][] visited; //거리저장배열
    static ArrayList<Point> ripe;

    static int[][] dr = {{0,-1}, {0,1}, {0,0}, {0,0}, {0,0}, {0,0}};
    static int[][] dc = {{0,0}, {0,0}, {0,-1}, {0,1}, {0,0}, {0,0}};
    static int[][] dh = {{0,0}, {0,0}, {0,0}, {0,0}, {-1,0}, {1,0}};

    static class Point{
        int h;
        int r;
        int c;
        public Point(int h, int r, int c){
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //col
        N = Integer.parseInt(st.nextToken()); //row
        H = Integer.parseInt(st.nextToken()); //height

        boxes = new int[H][N][M];
        visited = new int[H][N][M];
        ripe = new ArrayList();

        boolean hasRaw = false;
        for(int h=0;h<H;h++){
            for(int r=0;r<N;r++){
                st = new StringTokenizer(br.readLine());
                Arrays.fill(visited[h][r], -1);
                for(int c=0;c<M;c++){
                    int tomato = Integer.parseInt(st.nextToken());
                    boxes[h][r][c] = tomato;
                    if(tomato==0) hasRaw = true;
                    if(tomato==1) ripe.add(new Point(h,r,c));
                }
            }
        }

        if(!hasRaw) sb.append(0);
        else{
            bfs(ripe);
            int day = 0;
            boolean stillHasRaw = false;
            for(int h=0;h<H;h++){
                for(int r=0;r<N;r++){
                    for(int c=0;c<M;c++){
                    	if(visited[h][r][c]==-1&&boxes[h][r][c]==0) {
                    		stillHasRaw = true;
                    		break;
                    	}
                        day = Math.max(visited[h][r][c], day);
                    }
                }
            }
            if(stillHasRaw) sb.append(-1);
            else sb.append(day);
        }


        System.out.println(sb.toString());
    }

    static void bfs(ArrayList<Point> arrList){
        Queue<Point> q = new LinkedList();
        for(Point e: arrList){
            q.add(e);
            visited[e.h][e.r][e.c] = 0;
        }

        while(!q.isEmpty()){
        	Point curr = q.poll();
        	for(int d=0;d<4;d++) {
        		int nr = curr.r + dr[d][1];
        		int nc = curr.c + dc[d][1];
        		if(nr<0||nc<0||nr>=N||nc>=M) continue;
        		if(boxes[curr.h][nr][nc]==-1||visited[curr.h][nr][nc]!=-1) continue;
        		visited[curr.h][nr][nc] = visited[curr.h][curr.r][curr.c] + 1;
        		q.add(new Point(curr.h,nr,nc));
        	}
        	for(int d=4;d<6;d++) {
        		int nh = curr.h + dh[d][0];
        		if(nh<0||nh>=H) continue;
        		if(boxes[nh][curr.r][curr.c]==-1||visited[nh][curr.r][curr.c]!=-1) continue;
        		visited[nh][curr.r][curr.c] = visited[curr.h][curr.r][curr.c]+ 1;
        		q.add(new Point(nh, curr.r, curr.c));
        	}
        }
    }
}

