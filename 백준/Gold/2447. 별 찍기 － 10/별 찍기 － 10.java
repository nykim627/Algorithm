import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(arr[i], '*');
		}
		divide(0, N-1, 0, N-1);
			
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

	private static void divide(int startR, int endR, int startC, int endC) {
		int len = endR-startR+1;
		if(len < 3) return;
		int midStartR = startR+len/3;
		int midEndR = startR+(len/3)*2 - 1;
		int midStartC = startC+len/3;
		int midEndC = startC+(len/3)*2 - 1;
		
		for(int i=midStartR;i<=midEndR;i++) {
			for(int j=midStartC;j<=midEndC;j++) {
				arr[i][j] = ' ';
			}
		}
		
		divide(startR, midStartR-1, startC, midStartC-1);
		divide(midStartR, midEndR, startC, midStartC-1);
		divide(midEndR+1,endR, startC, midStartC-1);
		divide(startR, midStartR-1, midStartC, midEndC);
		divide(midEndR+1,endR, midStartC, midEndC);
		divide(startR, midStartR-1, midEndC+1, endC);
		divide(midStartR, midEndR, midEndC+1, endC);
		divide(midEndR+1,endR, midEndC+1, endC);
	}

}
