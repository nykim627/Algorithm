import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//방배정
		
		int n = sc.nextInt(); //총 학생 수
		int k = sc.nextInt(); //한방에 배정할 수 있는 최대인원수
		
		//각 성별의 학년에 대한 카운팅배열 만들기
		int[] girls = new int[7]; //0학년부터 6학년까지
		int[] boys = new int[7];
		
		
		//카운팅 배열 채우기
		for(int i=0;i<n;i++) {
			int sex = sc.nextInt(); //성별(여 0, 남 1)
			int grade = sc.nextInt(); //학년
			
			if(sex==0) {
				girls[grade]++;
			}else {
				boys[grade]++;
			}
		}
		
		//각 카운팅 배열값의 k로 나눈 몫을 더하기
		int sum = 0;
		for(int i=0;i<7;i++) {
			sum += girls[i]%k==0 ? girls[i]/k : girls[i]/k+1;
			sum += boys[i]%k==0 ? boys[i]/k : boys[i]/k+1;
		}
		
		System.out.println(sum);
	
	}

}
