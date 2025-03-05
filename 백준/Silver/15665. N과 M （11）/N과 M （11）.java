import java.io.*;
import java.util.*;

public class Main {
    static int[] arr; // 입력받은 배열
    static int N, M;  // N개의 수 중 M을 뽑는다
    static int[] sel; // 뽑은 M개의 수를 저장하는 배열
    static Set<String> result; // 결과를 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 정렬하여 사전 순으로 출력
        Arrays.sort(arr);

        // 중복 순열을 뽑기 위한 배열 초기화
        sel = new int[M];
        result = new LinkedHashSet<>();

        // 중복 순열을 구하는 메서드 호출
        perper(0);

        // 결과 출력
        for (String e : result) {
            bw.write(e + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 중복 순열을 구하는 메서드
    static void perper(int depth) {
        if (depth == M) {
            // M개의 숫자를 고른 경우, 결과를 String 형태로 리스트에 저장
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            result.add(sb.toString().trim()); // List에 추가
            return;
        }

        // 중복 순열이므로 i부터 다시 시작해도 중복 가능
        for (int i = 0; i < N; i++) {
            sel[depth] = arr[i];
            perper(depth + 1); // 재귀 호출
        }
    }
}
