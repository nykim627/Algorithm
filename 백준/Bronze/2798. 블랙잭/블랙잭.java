import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int final_sum = 0;
		int final_i = 0;
		int final_j = 0;
		int final_k = 0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int sum = arr[i]+arr[j]+arr[k];
					if(sum<=m) {
						if(m-sum<min) {
							min = m-sum;
							final_sum = sum;
//							final_i = arr[i];
//							final_j = arr[j];
//							final_k = arr[k];
						}
					}
				}
			}
		}
		System.out.println(final_sum);
//		System.out.println(final_i);
//		System.out.println(final_j);
//		System.out.println(final_k);
	}
}