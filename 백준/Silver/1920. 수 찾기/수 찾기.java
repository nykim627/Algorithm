import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {  //입출력 예외 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 모든 정수의 범위가 2^(-31) ~ 2^(31)이므로 정수 타입을 int로 지정
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 빠른 검색을 위해 HashSet으로 배열 생성
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine()); // 모든 정수의 범위가 2^(-31) ~ 2^(31)이므로 정수 타입을 int로 지정
        st = new StringTokenizer(br.readLine()); // st를 초기화
        
        // m개의 각 원소에 대해 set에서 존재 여부를 확인
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) {
                System.out.println(1);  // 존재하면 1 출력
            } else {
                System.out.println(0);  // 존재하지 않으면 0 출력
            }
        }
    }
}
