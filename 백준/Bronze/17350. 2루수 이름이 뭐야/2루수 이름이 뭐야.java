import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		if(set.contains("anj")) System.out.println("뭐야;");
		else System.out.println("뭐야?");
	}
}