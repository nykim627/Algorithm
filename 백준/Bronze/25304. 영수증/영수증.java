import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int price = Integer.parseInt(br.readLine());
		int num =Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=1;i<=num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum += a*b;
		}
		System.out.println(sum==price ? "Yes" : "No");
		
	}
}
