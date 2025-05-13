import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		boolean isPal = true;
		for(int i=0;i<=input.length()/2;i++) {
			if(input.charAt(i)!=input.charAt(input.length()-1-i)) {
				isPal = false;
				break;
			}
		}
		
		if(isPal) System.out.println(1);
		else System.out.println(0);

		br.close();

	}
}
