import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int N;
	
	static int[] tmp; //임시공간
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
		arr = new int[1000000];
		N = arr.length;
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		//메소드이용
//		Arrays.sort(arr);
//		System.out.println(arr[500000]);
		
		//병합정렬
//		tmp = new int[N];
//		mergeSort(0,N-1);
//		System.out.println(arr[500000]);
//		
		//퀵정렬
		quickSort(0,N-1);
		System.out.println(arr[500000]);
		
	}//main
	
	static void mergeSort(int start, int end) {
		if(start>=end) return;
		int mid = (start+end)/2;
		mergeSort(start, mid);
		mergeSort(mid+1,end);
		merge(start, mid, end);
	}//mergeSort
	
	static void merge(int start, int mid, int end) {
		int L = start;
		int R = mid+1;
		
		int idx = start;
		
		while(L<=mid&&R<=end) {
			if(arr[L]<=arr[R]) tmp[idx++] = arr[L++];
			else tmp[idx++] = arr[R++];
		}//한쪽 정렬 완료
		
		if(L<=mid) {
			for(int i=L;i<=mid;i++) {
				tmp[idx++] = arr[i];
			}
		}else {
			for(int i=R;i<=end;i++) {
				tmp[idx++] = arr[i];
			}
		}//남은 구간 털기
		
		for(int i=start;i<=end;i++) {
			arr[i] = tmp[i];
		}//기존 배열에 덮어쓰기
		
	}//merge
	
	static void quickSort(int start, int end) {
		if(start<end) {
//			int pivot = hoarePartition(start, end);
			int pivot = lomutoPartition(start, end);
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);			
		}
	}//quickSort()
	
	static int hoarePartition(int start, int end) {
		int pivot = arr[start];
		int L = start+1;
		int R = end;
		
		while(L<=R) {
			while(L<=R && arr[L]<=pivot) L++;
			while(arr[R]>pivot) R--;
			if(L<R) {
				swap(L,R);				
			}
		}
		
		swap(start,R);
		
		return R;
	}//hoarePartition
	
	static int lomutoPartition(int start, int end) {
		int pivot = arr[end];
		int i = start-1;
		for(int j=start;j<end;j++) {
			if(arr[j]<=pivot) {
				i++;
				swap(i,j);
			}
		}
		swap(i+1,end);
		return i+1;
	}//lomutoPartition
	
	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}//swap
}
