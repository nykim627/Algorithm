import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point>{
    	int from;
        int to;
        int dist;
        public Point(int from, int to, int dist){
        	this.from = from;
        	this.to = to;
        	this.dist = dist;
        }
		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist; //거리 기준 오름차순 정렬
		}
    }
    
    static int N, M;
    static Point[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //사다리 수
        M = Integer.parseInt(st.nextToken()); //뱀의 수
        
        map = new Point[101];
        visited = new boolean[101];
        for(int i=0;i<=100;i++) {
        	map[i] = new Point(i,i,0);
        }
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	map[x].to = y;
        }
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	map[x].to = y;
        }
        
        bfs(map[1]);
        
        sb.append(map[100].dist);
        

        System.out.println(sb.toString());
    }

	private static void bfs(Point start) {
		PriorityQueue<Point> pq = new PriorityQueue();
		pq.add(start);
//		visited[0] = true;
		
		while(!pq.isEmpty()) {
			Point curr = pq.poll();
			if(curr.from==100) return;
			for(int i=1;i<=6;i++) {
				if(curr.from+i > 100) continue;
				int nextIdx = map[curr.from + i].to;
				if(visited[nextIdx]) continue;
				visited[nextIdx] = true;
				map[nextIdx].dist = map[curr.from].dist + 1;
				pq.add(map[nextIdx]);
			}
		}
		return;
	}
}

