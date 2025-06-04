import java.util.*;
import java.io.*;

public class Main{
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Point[] arr = new Point[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x,y);
		}
		
		Arrays.sort(arr, (cur, pos)->{
			if(cur.y==pos.y) return cur.x-pos.x;
			return cur.y-pos.y;
		});
		
		StringBuilder sb = new StringBuilder();
		for(Point e: arr) {
			sb.append(e.x).append(" ").append(e.y).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}