import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res1 = 0;
		int res2 = 0;
		int res3 = 0;
		for(int i=1;i<=N;i++) {
			res1+=i;
			res3+=i*i*i;
		}
		res2 = res1*res1;
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		
		
	}

}