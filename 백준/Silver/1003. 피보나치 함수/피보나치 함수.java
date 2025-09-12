import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

/*int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}

 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxN = 0;
        int[] arr = new int[T];
        for(int tc=0;tc<T;tc++){
            int N = Integer.parseInt(br.readLine());
            arr[tc] = N;
            if(N>maxN) maxN = N;
        }

        int[] zeros = new int[maxN+1];
        int[] ones = new int[maxN+1];

        zeros[0] = 1;
        if(maxN>=1) ones[1] = 1;
        for(int i=2;i<=maxN;i++){
            zeros[i] = zeros[i-1]+zeros[i-2];
            ones[i] = ones[i-1]+ones[i-2];
        }

        for(int tc=0;tc<T;tc++){
            System.out.println(zeros[arr[tc]]+" "+ones[arr[tc]]);
        }
    }
}