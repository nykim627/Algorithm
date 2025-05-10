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
		int z = Integer.parseInt(br.readLine());
		
		if(y+z<60) {
			y += z;
		}else {
			if(x+(y+z)/60>=24) {
				x = x+(y+z)/60-24;
				y = (y+z)%60;
			}else {
				x = x+(y+z)/60;
				y = (y+z)%60;
			}
		}
		System.out.println(x+" "+y);
	}
}
