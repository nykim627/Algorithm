import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //수의 개수
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        //배열값 입력
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine()); //10,000보다 작거나 같은 자연수
            if(max<arr[i]){
                max = arr[i];
            }
        }

        //카운팅정렬
        int[] cnt = new int[max+1]; //카운팅배열(0~max까지 저장)
        for(int i=0;i<n;i++){
            cnt[arr[i]]++;
        }
        for(int i=1;i<cnt.length;i++){ //누적카운트 배열로 만들기
            cnt[i] += cnt[i-1];
        }

        int[] sortArr = new int[n]; //정렬된 배열 만들기
        for(int i=n-1;i>=0;i--){
            int tmp = cnt[arr[i]]-1;
            sortArr[tmp] = arr[i];
            cnt[arr[i]]--;
        }

        //결과 출력
        for(int i=0;i<n;i++){
            bw.write(sortArr[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
