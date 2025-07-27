import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int subin, sister;
	static int[] times;
	static int[] dr;
	
	static class Pos implements Comparable<Pos>{
		int x;
		int dist;
		
		public Pos(int a, int i) {
			this.x = a;
			this.dist = i;
		}

		@Override
		public int compareTo(Pos o) {
			return this.dist - o.dist;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());
        
        times = new int[100001];
        Arrays.fill(times, -1);
        
        int res = bfs(subin, sister);
        
        System.out.println(res);
        
    }
	private static int bfs(int a, int b) {
		PriorityQueue<Pos> pq = new PriorityQueue();
		pq.add(new Pos(a,0));
		times[a] = 0;
		
		while(!pq.isEmpty()) {
			Pos curr = pq.poll();
			//System.out.println(curr.x);
			if(curr.x==b) return curr.dist;
			dr = new int[] {curr.x,-1,1};
			for(int d=0;d<3;d++) {
				int nr = curr.x + dr[d];
				if(nr<0||nr>100000) continue;
				int nexttime = d==0 ? curr.dist : curr.dist + 1; //순간이동하는 경우는 추가되는 시간 없음
				if(times[nr]!=-1 && times[nr]<=nexttime) continue; //이미 방문한 칸의 시간이 nexttime보다 더 적으면 패스
				//방문 안했거나, 이미 방문했어도 nexttime이 더 적으면 최소시간 갱신
				times[nr] = nexttime; 
				pq.add(new Pos(nr, nexttime));
			}
		}
		
		return -1;
	}
    
}