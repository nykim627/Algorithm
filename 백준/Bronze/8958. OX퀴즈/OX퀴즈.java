import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			String[] str = br.readLine().split("X");
			int point = 0;
			for(String e: str) {
				int N = e.length();
				point += N*(N+1)/2;
			}
			System.out.println(point);
		}
	}

}