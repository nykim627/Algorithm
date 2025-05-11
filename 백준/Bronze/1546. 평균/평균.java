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

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		double[] newArr = new double[n];
		double sum = 0;
		for(int i=0;i<n;i++) {
			newArr[i] = ((double)arr[i])/max * 100;
			sum += newArr[i];
		}
		
		System.out.println(sum/n);

		br.close();

	}
}
