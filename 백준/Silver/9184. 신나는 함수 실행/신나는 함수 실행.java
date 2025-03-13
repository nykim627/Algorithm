import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//B9184 신나는 함수 실행
//시간:
//메모리:
//아이디어: 재귀 활용, memoization
public class Main {
	static int a;
	static int b;
	static int c;
	static int[][][] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		memo = new int[21][21][21];
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); //-50 ≤ a, b, c ≤ 50
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a==-1&&b==-1&&c==-1) {
				break;
			}else {
				bw.write(String.format("w(%d, %d, %d) = ", a,b,c)+recur(a,b,c)+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}//main
	
	static int recur(int a, int b, int c) {
		if(a<=0||b<=0||c<=0) return 1;
		else if(a>20||b>20||c>20) return recur(20,20,20);
		else if(memo[a][b][c]>=1) return memo[a][b][c];
		else if(a<b&&b<c) {
			memo[a][b][c-1] = recur(a,b,c-1);
			memo[a][b-1][c-1] = recur(a,b-1,c-1);
			memo[a][b-1][c] = recur(a,b-1,c);
			return memo[a][b][c-1]+memo[a][b-1][c-1]-memo[a][b-1][c];
		}
		else {
			memo[a-1][b][c] = recur(a-1,b,c);
			memo[a-1][b-1][c] = recur(a-1,b-1,c);
			memo[a-1][b][c-1] = recur(a-1,b,c-1);
			memo[a-1][b-1][c-1] = recur(a-1,b-1,c-1);
			return memo[a-1][b][c]+memo[a-1][b-1][c]+memo[a-1][b][c-1]-memo[a-1][b-1][c-1];
		}
	}//recur
}
