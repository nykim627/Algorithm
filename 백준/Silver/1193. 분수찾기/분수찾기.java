import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//더해서 짝수인 경우 : 왼 -> 오
		//더해서 홀수인 경우 : 오 -> 왼
		int x = Integer.parseInt(br.readLine());
		int n = 1;
		while(x>(n-1)*n/2) n++;
		if(n==2) {
			System.out.println("1/1");
		}else {
			int k = x-(n-1)*(n-2)/2;
			if(n%2==0) System.out.println((n-k)+"/"+k);
			else System.out.println(k+"/"+(n-k));
		}

		br.close();

	}
}
