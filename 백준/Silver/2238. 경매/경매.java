import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int u = sc.nextInt();//최대가격
		int n = sc.nextInt();//경매 참여 횟수
		
		String [] name =new String[n];
		int [] price = new int[n];
		
		int [] count = new int[u+1];
	
		for(int i = 0 ; i<n ; i++) {
			name[i] = sc.next();
			price[i] = sc.nextInt();
		}
		
		//count(빈도수 배열)완성
		for(int i = 0; i<u+1 ; i++) {
			for(int k = 0 ; k<n ; k++) {
				if(i == price[k]) {
					count[i]++;
				}
			}
		}
		
		//System.out.println(Arrays.toString(count));
		//count(가격을 번호로 하고 빈도수값을 가진 배열)에서 최소 빈도값
		int min = Integer.MAX_VALUE;
		for(int i =0; i<u+1 ; i++) {
			if(count[i]<=min && count[i]>=1) {
				min = count[i];
			}
		}
		//빈도가 여러개 일 수 있으니 그 값의 개수 mincount
		int mincount = 0;
		for(int i=0; i<u+1 ; i++) {
			if(count[i]==min) {
				mincount++;
			}
		}
		//System.out.println(mincount);
		// 최소 빈도수를 가지는 가격들의 배열 minBin
//		int [] minBin = new int[mincount];
//		for(int i = 0 ; i<u+1; i++) {
//			for(int k = 0 ; k<mincount ; k++) {
//				if(count[i]==min) {
//					minBin[k]=i;
//				}
//			}
//		}
		//System.out.println(min);
		int [] minBin = new int[mincount];
		int minBing=0;
			for(int i = 0 ; i<u+1; i++) {
				if(count[i]==min) {
					minBin[minBing]=i;
					minBing++;
				}
				}
		
		//System.out.println(Arrays.toString(minBin));
		
		// 그리고 그중에서 가장 가장 낮은 가격 minBinmin
		int minBinmin = Integer.MAX_VALUE;
		for(int i =0; i<mincount ; i++) {
			if(minBin[i]<minBinmin) {
				minBinmin=minBin[i];
			}
		}
		//idx는 price배열에서 최소 빈도에 가장 싼 가격을 가진 인덱스번호 배열 
//		int [] idx = new int[mincount];
//		int idxValue = 0;
//	
//		for(int k =0 ; k < n ; k++) {
//			if(price[k] == minBinmin) {
//				idx[idxValue] =k; 
//				idxValue++;
//			}
//		}
		int idx = 0;
		for(int i =1 ; i<n ; i++) {
			if(price[i] == minBinmin) {
				idx = i;
				break;
			}
		}
		
		System.out.println(name[idx] + " " + price[idx]);
		

	}

}
