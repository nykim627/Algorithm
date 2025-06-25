import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			char tmp = str.charAt(i);
			if(Character.isLowerCase(tmp)) {
				sb.append(Character.toUpperCase(tmp));
			}else sb.append(Character.toLowerCase(tmp));
		}

		System.out.println(sb.toString());
	}

}
