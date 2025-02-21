import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); // tc수

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 수행해야하는 연산의 수(1<=n<=10^5)
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); //최대힙 두현 위한 비교기준

			bw.write("#" + tc+ " ");
			
			for (int i = 0; i < n; i++) { // 연산 정보 입력
				StringTokenizer st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				if (order==1) { // 연산1
					int num = Integer.parseInt(st.nextToken());
					pq.add(num); 
				} else if(order==2) { // 연산2
					//결과 출력
					if (pq.isEmpty()) { //힙이 비어있는지 확인
						bw.write(-1 + " "); //연산 끝나기 전까진 끝난 게 아니다~~
					} else {
						bw.write(pq.poll() + " ");
					}
				}
			}
			
			bw.newLine(); //bw.write("\n");과 동일
			
		} // tc순회 끝
		
		bw.flush(); 
		br.close();
		bw.close();
	}
}