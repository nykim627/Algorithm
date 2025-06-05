import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		for (long i = 1; i <= 100000000; i++) {
			if ((A * i) % B == 0) {
				sb.append(A * i).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());

	}
}