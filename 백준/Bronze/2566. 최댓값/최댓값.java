import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totalm = 0;
		int idx1 = 1, idx2 = 1;  //모든 값이 0일 때, idx1, idx2를 1로 초기화해둬야지 1행1열이 나온다
		int[][] arr = new int[9][9];
		
		
		for (int i = 0; i < 9; i++) {
			for(int j=0;j<9;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 9; i++) {
			for(int j=0;j<9;j++) {
				if (totalm<arr[i][j]) {
					totalm=arr[i][j];
					idx1 = i+1;
					idx2 = j+1;
				}
			}
		}
		System.out.println(totalm);
		System.out.println(idx1+" "+idx2);
		
		sc.close();
	}
}