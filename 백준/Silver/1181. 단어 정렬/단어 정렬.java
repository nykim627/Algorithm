//문제번호: 1181
//메모리:
//시간:

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //단어 정렬

        int n = Integer.parseInt(br.readLine()); //단어 개수 (1 이상 20000 이하)
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        //배열값 입력
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            if (!pq.contains(tmp)) {
                pq.add(tmp);
            }
        }

        int size = pq.size();
        for (int i = 0; i < size; i++) {
            bw.write(pq.poll() + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
