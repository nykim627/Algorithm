import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15]; // 기본값 '\0' (null character)로 초기화됨

        // 입력 처리
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // 출력 처리
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < 15; c++) { 
            for (int r = 0; r < 5; r++) { 
                if (arr[r][c] != '\0') {  // '\0'이면 건너뜀
                    sb.append(arr[r][c]);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
