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

		//카운트배열에 나머지로 나오는 값 ++하고 1이상인 인덱스 개수 세기
		int[] cnt = new int[42];
		for(int i=1;i<=10;i++) {
			int tmp = Integer.parseInt(br.readLine())%42;
			cnt[tmp]++;
		}
		
		int res=0;
		for(int i=0;i<42;i++) {
			if(cnt[i]>0) res++;
		}
		System.out.println(res);

		br.close();

	}
}
