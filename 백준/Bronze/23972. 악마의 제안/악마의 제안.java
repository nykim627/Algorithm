import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long K = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		
		System.out.println(N==1 ? -1 : (N*K%(N-1)==0 ? N*K/(N-1) : N*K/(N-1)+1));
	}

}