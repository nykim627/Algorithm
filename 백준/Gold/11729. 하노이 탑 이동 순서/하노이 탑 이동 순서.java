import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb; //실행순서 담을 sb
	static int cnt; //총 실행횟수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		cnt = 0;
		hanoi(N,1,2,3);
		
		System.out.println(cnt);  //총 실행횟수 먼저 출력
		System.out.println(sb.toString());
	}
	
	static void hanoi(int n, int from, int via, int to) {
		if(n==0) return;
		hanoi(n-1, from, to, via);
		cnt++;
		sb.append(from).append(" ").append(to).append("\n"); //위의 재귀가 다 끝나고 가장 위에 있는 원판에 대해 작용
		hanoi(n-1, via, from, to);
	}


}
