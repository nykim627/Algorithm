import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//플로이드워셜 (단, 음의 가중치 없음 -> 거리 배열 int[][]로 선언해도 상관없음)
class Main {
	static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] dist = new int[N+1][N+1];
        for(int i=1;i<=N;i++) { //일단 다 INF 채우기
        	Arrays.fill(dist[i], INF);
        }
        for(int i=1;i<=N;i++) { //자기자신은 0으로 채우기
        	dist[i][i] = 0;
        }
        
        for(int i=0;i<M;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	dist[a][b] = Math.min(dist[a][b], c); //최솟값으로 채움(시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다!!)
        }
        
        //경->출->도!
        for(int i=1;i<=N;i++) { //경유지
        	for(int j=1;j<=N;j++) { //출발지
        		if(dist[j][i]==INF) continue; //출->경 거리 무한대면 패스!
        		for(int k=1;k<=N;k++) { //도착지
        			if(dist[i][k]==INF) continue; //경->도 거리 무한대면 패스!
        			dist[j][k] = Math.min(dist[j][k], dist[j][i]+dist[i][k]);
        		}
        	}
        }
        
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		if(dist[i][j]==INF) sb.append("0 ");
        		else sb.append(dist[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}