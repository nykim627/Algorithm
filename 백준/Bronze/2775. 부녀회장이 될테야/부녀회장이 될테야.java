import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); //tc수

        for(int tc=1;tc<=t;tc++){
            int k = Integer.parseInt(br.readLine()); //층
            int n = Integer.parseInt(br.readLine()); //호

            int[][] apt = new int[k+1][n+1]; //0~k층, 0~n호로 이루어진 아파트. (0호는 0명 살아서 상관 x)
            for(int c=0;c<=n;c++){ //0층 채우기
                apt[0][c] = c;
            }
            for(int r=1;r<=k;r++){ //1층부터 채우기
                for(int c=1;c<=n;c++){ //1호부터 채우기
                    apt[r][c] = apt[r][c-1] + apt[r-1][c]; //k층 n호 인원 = k층 n-1호 인원 + k-1층 n호 인원
                }
            }
//            System.out.println(Arrays.deepToString(apt));

            bw.write(apt[k][n]+""); //bw.write로 숫자 출력 시 문자열로 변환후 출력시켜줘야 한다!!!
            bw.newLine();


        }//tc순회끝

        bw.flush();
        bw.close();
        br.close();

    }
}
