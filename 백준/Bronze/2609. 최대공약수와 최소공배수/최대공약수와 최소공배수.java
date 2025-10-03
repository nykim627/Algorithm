import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int a = A;
		int b = B;
		int r = a%b;
		while(r!=0) {
			a = b;
			b = r;
			r = a%b;
		} //멈췄을때의 b(나누는 수)가 최대공약수
		System.out.println(b);
		System.out.println(A*B/b);
	}
}