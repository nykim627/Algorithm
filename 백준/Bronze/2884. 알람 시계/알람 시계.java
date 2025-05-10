import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if(y>=45) {
			y -= 45;
		}else {
			if(x==0) {
				x=23;
				y = 60+y-45;
			}else {
				x-=1;
				y = 60+y-45;
			}
		}
		System.out.println(x+" "+y);
	}
}
