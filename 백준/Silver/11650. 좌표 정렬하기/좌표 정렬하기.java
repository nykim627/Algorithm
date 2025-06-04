import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static class Point implements Comparable<Point>{
		int x;
		int y;
		
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

		@Override
		public int compareTo(Point o) {
			if(this.x==o.x) {
				return this.y-o.y; //y오름차순
			}
			return this.x-o.x; //x오름차순
		}
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	points[i] = new Point(x,y);
        }
        
        Arrays.sort(points); //compareTo기준으로 정렬
        
        for(Point e: points) {
        	System.out.println(e.x+" "+e.y);
        }
        
    }
}