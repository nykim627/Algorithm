import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[100][100];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int colStart = Integer.parseInt(st.nextToken());
			int rowStart = Integer.parseInt(st.nextToken());
			for(int row=rowStart;row<rowStart+10;row++) {
				for(int col=colStart;col<colStart+10;col++) {
					arr[row][col]++;
				}
			}
			
		}
		int cnt=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]>0) cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();

	}
}
