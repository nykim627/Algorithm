import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//특정 번호의 창문을 닫으려면 그 번호에 대한 약수의 개수가 홀수개여야 한다. 즉, 그 번호는 어떤 수의 제곱수여야 한다!!!
//1이상 N이하의 수 중에서 제곱수는 당연히 sqrt(N)개 존재한다.
public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int window = 0;
		for(int i=1;i<=Math.sqrt(N);i++) {
			if(i*i<=N) window++;
		}
		
		sb.append(window);
		
		System.out.println(sb.toString());
	}
}
