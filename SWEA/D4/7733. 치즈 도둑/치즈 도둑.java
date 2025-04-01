import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int maxNum, num, maxDay;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //tc수
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine()); //치즈 한 변의 길이
			arr = new int[N][N];
			maxDay = 0;
			StringTokenizer st;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, arr[i][j]);
				}
			}//입력
			
			//확인용 출력
//			System.out.println(Arrays.deepToString(arr));
			
			maxNum = Integer.MIN_VALUE;
			
			//1일부터 maxDay까지 순회
			for(int day=1;day<=maxDay;day++) {
				visited = new boolean[N][N];
				num = 0; //덩어리 수
				
				//요정이 치즈먹어
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j]==day) arr[i][j]=0;
					}
				}
				
				//0아니고 아직 방문안한 칸에 대해 dfs 수행 & 덩어리 수 +1
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j]!=0 && !visited[i][j]) {
							bfs(i,j);
							num++;
						}
					}
				}
				
				if(maxNum<num) maxNum = num; //최대 덩어리 개수 갱신
			}//day순회
			
			sb.append(maxNum==0 ? 1 : maxNum).append("\n");
			
		}//tc
		
		System.out.println(sb.toString());
		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			for(int d=0;d<4;d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue; //범위췤
				if(arr[nr][nc]==0) continue; //치즈있는지 췤
				if(visited[nr][nc]) continue; //방문췤
				
				visited[nr][nc]=true;
				q.add(new int[] {nr,nc});
			}
		}
	}
}
