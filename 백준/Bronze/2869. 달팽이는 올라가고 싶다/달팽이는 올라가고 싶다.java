import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());  //낮에올라감
		int B = Integer.parseInt(st.nextToken());  //밤에내려감
		int V = Integer.parseInt(st.nextToken());  //나무높이
		
		int tmp = V-A; //낮밤 둘다 지내야 하는 최소 높이
		
		int cnt = 0;
		if(tmp%(A-B)==0) {
			cnt = tmp/(A-B) + 1;
		}else {
			cnt = tmp/(A-B) + 2;
		}
		
		System.out.println(cnt);
	}
}

