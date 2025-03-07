import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	static boolean[][] visited;
	static int cnt; //퀸을 놓는 방법의 총 개수
	static int[] dr = {-1,-1,-1}; //좌상, 상, 우상
	static int[] dc = {-1,0,1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		//서로 다른 두퀸 -> 순열문제! 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
        	N = Integer.parseInt(br.readLine());
        	visited = new boolean[N][N];
        	
        	cnt = 0;
        	queen(0);
        	
        	bw.write("#"+tc+" "+cnt+"\n"); //결과출력
        }//tc순회

        bw.flush();
        bw.close();
        br.close();
	}//main
	
	static void queen(int depth) {
		//종료
		if(depth==N) {
			cnt++;
			return;
		}
		
		//재귀
		for(int col=0;col<N;col++) {
			int r = depth;
			int c = col;
			boolean isOK = true;
			Loop:
			for(int i=0;i<=depth;i++) {
				for(int d=0;d<3;d++) {
					int nr = r + dr[d]*i;
					int nc = c + dc[d]*i;
					
					if(nr>=0&&nr<N&&nc>=0&&nc<N) {
						if(visited[nr][nc]) {
							isOK = false;
							break Loop;
						}
					}
				}
			}
			if(isOK) {
				visited[r][c] = true;
				queen(depth+1);
				visited[r][c] = false;
			}
		}
		
	}//queen
	
	
}
