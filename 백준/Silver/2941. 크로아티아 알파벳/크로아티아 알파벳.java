import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		if(input.contains("c=")) {
			input = input.replace("c=", "*");
		}
		if(input.contains("c-")) {
			input = input.replace("c-", "*");
		}
		if(input.contains("dz=")) {
			input = input.replace("dz=","*");
		}
		if(input.contains("d-")) {
			input = input.replace("d-", "*");
		}
		if(input.contains("lj")) {
			input = input.replace("lj", "*");
		}
		if(input.contains("nj")) {
			input = input.replace("nj", "*");
		}
		if(input.contains("s=")) {
			input = input.replace("s=", "*");
		}
		if(input.contains("z=")) {
			input = input.replace("z=", "*");
		}
		
		System.out.println(input.length());
		
		br.close();

	}
}
