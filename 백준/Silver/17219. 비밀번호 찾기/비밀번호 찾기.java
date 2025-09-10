import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		HashMap<String, String> hm = new HashMap<>();
		for(int i=0;i<M;i++) {
			String[] str = br.readLine().split(" ");
			hm.put(str[0], str[1]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			sb.append(hm.get(str)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}