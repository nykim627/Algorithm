import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = 10; //tc수

		for (int tc = 1; tc <= t; tc++) {
			int tcNum = sc.nextInt();
			String test = sc.next();

			StringBuilder br = new StringBuilder(sc.next());
			
			int count = 0;
			for(int i=0;i<=br.length()-test.length();i++) {
				if(test.equals(br.substring(i, i+test.length()).toString())) {  //String과 String 형태로 비교해줘야함
					count++;
				}
			}
			
			System.out.println("#" + tcNum + " " + count);
		} //tc 반복 끝
	}
}
