import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringBuilder sb = new StringBuilder(input);
		String[] arr = sb.reverse().toString().split(" ");
		System.out.println(Math.max(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
		
		br.close();

	}
}
