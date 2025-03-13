import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

//B1992 쿼드트리
//시간:
//메모리:
//아이디어: 분할정복, 재귀 활용
public class Main {
	static char[][] arr; //흑백영상배열
	int N; //정사각형의 가로세로길이
	static int blackWhite=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //영상의 크기(2의 제곱수. 1<=N<=64)
		arr = new char[N][N];
		
		//배열값채우기
		for(int i=0;i<N;i++) {
			String str = br.readLine().strip();
			for (int j = 0; j <N; j++) {
				char tmp = str.charAt(j);
				arr[i][j] = tmp;
			}
		}
		
		recur(0,N-1,0,N-1);
		
		bw.write(sb.toString()+"");
		
		bw.flush();
		bw.close();
		br.close();
		
	}//main
	
	static void recur(int rStart, int rEnd, int cStart, int cEnd) {
		if(rStart>rEnd || cStart>cEnd) return;
		int cnt = 0; //파란색 개수
		for(int i=rStart;i<=rEnd;i++) {
			for(int j=cStart;j<=cEnd;j++) {
				if(arr[i][j]=='1') {
					cnt++;
				}
			}
		}
		if(cnt==0) {
			sb.append(0);
			return;
		}else if(cnt==(rEnd-rStart+1)*(cEnd-cStart+1)) {
			sb.append(1);
			return;
		}
		sb.append("(");
		recur(rStart,(rStart+rEnd+1)/2-1,cStart,(cStart+cEnd+1)/2-1); //왼쪽 위
		recur(rStart,(rStart+rEnd+1)/2-1,(cStart+cEnd+1)/2,cEnd); //오른쪽 위
		recur((rStart+rEnd+1)/2,rEnd,cStart,(cStart+cEnd+1)/2-1); //왼쪽 아래
		recur((rStart+rEnd+1)/2,rEnd,(cStart+cEnd+1)/2,cEnd); //오른쪽 아래
		sb.append(")");
	}//recur
}
