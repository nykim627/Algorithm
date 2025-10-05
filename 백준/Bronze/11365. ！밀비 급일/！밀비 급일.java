import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(!str.equals("END")) {
			StringBuilder sb = new StringBuilder(str);
			System.out.println(sb.reverse().toString());
			str = br.readLine();
		}
	}
}