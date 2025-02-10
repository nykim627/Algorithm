import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int u = sc.nextInt();
		int n = sc.nextInt();
		
		String [] name =new String[n];
		int [] price = new int[n];
		
		int [] count = new int[u+1];
	
		for(int i = 0 ; i<n ; i++) {
			name[i] = sc.next();
			price[i] = sc.nextInt();
		}
		for(int i = 0; i<u+1 ; i++) {
			for(int k = 0 ; k<n ; k++) {
				if(i == price[k]) {
					count[i]++;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i =0; i<u+1 ; i++) {
			if(count[i]<=min && count[i]>=1) {
				min = count[i];
			}
		}
		int mincount = 0;
		for(int i=0; i<u+1 ; i++) {
			if(count[i]==min) {
				mincount++;
			}
		}
		int [] minBin = new int[mincount];
		int minBing=0;
			for(int i = 0 ; i<u+1; i++) {
				if(count[i]==min) {
					minBin[minBing]=i;
					minBing++;
				}
				}
		int minBinmin = Integer.MAX_VALUE;
		for(int i =0; i<mincount ; i++) {
			if(minBin[i]<minBinmin) {
				minBinmin=minBin[i];
			}
		}
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
