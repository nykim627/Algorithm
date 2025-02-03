import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int m = 2;
		int answer = 0;
		while(m!=0) {
			if(n==1) {
				answer = 1;
                m=0;
			}else {
				// 등차수열의 합 = ((첫째항+마지막항)*(항개수))/2
				int sum_m = 3*(m-1)*(m-1)+3*(m-1)+1;   //m층까지의 등차수열의 합
				int sum_m_1 = 3*(m-2)*(m-2)+3*(m-2)+1;  //m-1층까지의 등차수열의 합
				if(sum_m>=n && sum_m_1<n) {
					answer = m;
					m=0;
				}else {
					m++;
				}
			}
		}
		System.out.println(answer);
	}
}
