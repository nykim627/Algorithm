import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

//B2630 색종이만들기
//시간:
//메모리:
//아이디어: 분할정복, 재귀 활용
public class Main {
	static int[][] arr; //색종이배열
	int N; //정사각형의 가로세로길이
	static int white=0;
	static int blue=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //전체 종이 크기(2,4,8,16,32,64,128 중 하나)
		arr = new int[N][N];
		StringTokenizer st;
		
		//배열값채우기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recur(0,N-1,0,N-1);
		
		bw.write(white+"\n"+blue);
		
		bw.flush();
		bw.close();
		br.close();
		
	}//main
	
	static void recur(int rStart, int rEnd, int cStart, int cEnd) {
		if(rStart>rEnd || cStart>cEnd) return;
		int cnt = 0; //파란색 개수
		for(int i=rStart;i<=rEnd;i++) {
			for(int j=cStart;j<=cEnd;j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		if(cnt==0) {
			white++;
			return;
		}else if(cnt==(rEnd-rStart+1)*(cEnd-cStart+1)) {
			blue++;
			return;
		}
		recur(rStart,(rStart+rEnd+1)/2-1,cStart,(cStart+cEnd+1)/2-1);
		recur(rStart,(rStart+rEnd+1)/2-1,(cStart+cEnd+1)/2,cEnd);
		recur((rStart+rEnd+1)/2,rEnd,cStart,(cStart+cEnd+1)/2-1);
		recur((rStart+rEnd+1)/2,rEnd,(cStart+cEnd+1)/2,cEnd);
	}//recur
}
