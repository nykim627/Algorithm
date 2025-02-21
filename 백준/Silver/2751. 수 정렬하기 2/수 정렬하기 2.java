//문제번호: 2751
//메모리:
//시간:

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //수의 개수(1 ≤ N ≤ 1,000,000)
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = 0; //기본 최소갑을 0으로 설정. 즉 양수만 입력되는 경우 최소값은 자동으로 0!!

        //배열값 입력
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine()); //절댓값이 1,000,000보다 작거나 같은 정수
            if(max<arr[i]){
                max = arr[i];
            }
            if(min>arr[i]){
                min = arr[i];
            }
        }

        //카운팅정렬
        int[] cnt = new int[max-min+1]; //카운팅배열(0 ~ max+Math.abs(min)까지 저장)
        for(int i=0;i<n;i++){
            cnt[arr[i] + Math.abs(min)]++;
        }
        for(int i=1;i<cnt.length;i++){ //누적카운트 배열로 만들기
            cnt[i] += cnt[i-1];
        }

        int[] sortArr = new int[n]; //정렬된 배열 만들기
        for(int i=n-1;i>=0;i--){
            int tmp = cnt[arr[i] + Math.abs(min)]-1;
            sortArr[tmp] = arr[i] + Math.abs(min);
            cnt[arr[i] + Math.abs(min)]--;
        }

        //결과 출력
        for(int i=0;i<n;i++){
            bw.write(sortArr[i]-Math.abs(min)+"\n"); //abs(min)만큼 반드시 빼줘야 함.
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
