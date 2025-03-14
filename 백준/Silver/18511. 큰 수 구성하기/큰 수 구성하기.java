
import java.util.*;
import java.io.*;

//B18511 큰 수 구성하기
//메모리
//시간
public class Main {
    static String N;
    static int K;
    static String[] arr;
    static String[] res;
    static int max;
    static int maxnum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new String[K];
        maxnum = 0;
        for(int i=0;i<K;i++){
            arr[i] = st.nextToken();
            maxnum = Math.max(Integer.parseInt(arr[i]),maxnum);
        }

        res = new String[N.length()];
        max = Integer.MIN_VALUE;

        combcomb(0);
        System.out.println(max+"");

    }//main

    static void combcomb(int m){
        if(m > 0){ // 최소 1자리 이상 숫자가 완성된 경우만 확인
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++){
                sb.append(res[i]);
            }
            int num = Integer.parseInt(sb.toString());
            if(num <= Integer.parseInt(N)){
                max = Math.max(max, num);
            }
        }

        if(m == res.length) return; // 길이 초과 방지

        for(int i = 0; i < arr.length; i++){
            res[m] = arr[i]; // 중복 선택 가능
            combcomb(m + 1); // 다음 자릿수 채우기
        }
    }

}
