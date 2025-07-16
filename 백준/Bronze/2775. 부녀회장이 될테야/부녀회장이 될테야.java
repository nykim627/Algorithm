import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[k+1][n+1];
			for(int j=1;j<=n;j++) {
				arr[0][j] = j;
			}
			for(int i=1;i<=k;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			}
			sb.append(arr[k][n]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
