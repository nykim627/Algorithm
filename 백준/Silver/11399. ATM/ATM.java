import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//모든 사람이 돈 인출하는 데 필요한 최소 시간의 합은 그 앞사람의 인출시간이 짧을수록 최소!! -> 정렬하자.
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt(); //배열값 넣기
			if(arr[i]>max) {
				max = arr[i]; //max 갱신
			}
			if(arr[i]<min) {
				min = arr[i]; //min 갱신
			}
		}
		
//		System.out.println(min);
//		System.out.println(max);
		
		int[] cnt = new int[max+1]; //0~max값까지 포함하는 카운팅배열
		for(int i=0;i<n;i++) {
			cnt[arr[i]]++;
		}
		for(int i=1;i<cnt.length;i++) {
			cnt[i] += cnt[i-1]; //카운팅배열을 누적합배열로 만들기
		}
		
		//카운팅정렬
		int[] sortArr = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			int idx = cnt[arr[i]]-1;
			sortArr[idx] = arr[i];
			cnt[arr[i]]--; //얘 빼먹으면 안됨!!!
		}
//		System.out.println(Arrays.toString(sortArr));
		
		//카운팅정렬된 배열을 누적합배열로 만들기 (각 k번째 사람이 돈 인출하는 데 걸리는 시간)
		int sum = 0; //모든 사람이 돈 일출하는데 필요한 총 시간
		for(int i=1;i<sortArr.length;i++) {
			sortArr[i] += sortArr[i-1];
		}
		
		for(int i=0;i<sortArr.length;i++) {
			sum += sortArr[i]; //누적합 구하기
		}
		
		System.out.println(sum);
	
	}

}
