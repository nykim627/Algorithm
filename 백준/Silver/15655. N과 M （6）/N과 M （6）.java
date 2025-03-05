// 문제: 백준 15655번 N과 M(6) => 중복x조합문제!
// 메모리: KB
// 시간: ms

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

        // 조합을 뽑기 위한 배열 초기화
        sel = new int[M];
        result = new LinkedHashSet<>();

        // 조합을 구하는 메서드 호출
        comb(0,0);

        // 결과 출력
        for (String e : result) {
            bw.write(e + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 조합을 구하는 메서드
    static void comb(int start, int depth) {
        if (depth==M) {
            // M개의 숫자를 고른 경우, 결과를 String 형태로 set에 저장
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            result.add(sb.toString().trim()); // set에 추가
            return;
        }
        for (int i = start; i < N; i++) {
            sel[depth] = arr[i]; // 현재 위치에 숫자 선택
            comb(i + 1, depth + 1); // 다음 숫자를 선택하기 위해 재귀 호출
        }
    }
}
