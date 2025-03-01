import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        //엄청난 부자2
        //1 ≤ m ≤ n ≤ 10^1000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger[] arr = n.divideAndRemainder(m);

        bw.write(arr[0]+"\n");
        bw.write(arr[1]+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
