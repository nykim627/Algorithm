import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String str = br.readLine().strip();
		while(!str.equals("0")) {
			boolean isPel = true;
			for(int i=0;i<str.length()/2;i++) {
				if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
					isPel = false;
					break;
				}
			}
			if(isPel) {
				sb.append("yes\n");
			}else sb.append("no\n");
			
			str = br.readLine();
		}

		
		System.out.println(sb.toString());
	}
}
