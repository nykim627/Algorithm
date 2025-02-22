//문제번호: 2751
//메모리:
//시간:

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //나이순 정렬: 안정정렬 위해 카운팅 정렬 이용

        int n = Integer.parseInt(br.readLine()); //(1 ≤ N ≤ 100,000)
        String[][] arr = new String[n][2];
        int max = Integer.MIN_VALUE;
        int min = 0; //나이는 음수 불가
        int age;

        //배열값 입력
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken(); //나이
            arr[i][1] = st.nextToken(); //이름
            age = Integer.parseInt(arr[i][0]);
            if(max<age){
                max = age;
            }
        }

        //카운팅정렬
        int[] cnt = new int[max-min+1]; //카운팅배열(0 ~ max+Math.abs(min)까지 저장)
        for(int i=0;i<n;i++){
            age = Integer.parseInt(arr[i][0]);
            cnt[age]++;
        }
        for(int i=1;i<cnt.length;i++){ //누적카운트 배열로 만들기
            cnt[i] += cnt[i-1];
        }

        String[][] sortArr = new String[n][2]; //정렬된 배열 만들기
        for(int i=n-1;i>=0;i--){
            age = Integer.parseInt(arr[i][0]);
            int tmp = cnt[age]-1;
            sortArr[tmp] = arr[i];
            cnt[age]--;
        }

        //결과 출력
        for(int i=0;i<n;i++){
            bw.write(sortArr[i][0]+" "+sortArr[i][1]+"\n"); //abs(min)만큼 반드시 빼줘야 함.
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
