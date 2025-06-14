import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			int len = (int) Math.pow(3, N);
			sb = new StringBuilder("-".repeat(len));
			divide(0, len-1);
			
			System.out.println(sb.toString());
		}
		
	}

	private static void divide(int start, int end) {
		int len = end-start+1;
		if(len < 3) return;
		int midStart = start+len/3;
		int midEnd = start+(len/3)*2 - 1;
		
		divide(start, midStart-1);
		for(int i=midStart;i<=midEnd;i++) {
			sb.setCharAt(i, ' ');
		}
		
		divide(midEnd+1,end);
	}

}
