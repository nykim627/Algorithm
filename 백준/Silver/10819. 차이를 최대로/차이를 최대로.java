

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//시간
//메모리
public class Main {
    static int n;
    static int[] arr; // 기존 배열
    static ArrayList<ArrayList<Integer>> resList;; //가능한 모든 순열 조합의 경우를 저장하는 배열리스트
    static ArrayList<Integer> res; // sub 저장배열
    static boolean[] visited; // 방문배열. 기본값 false.

    public static void main(String[] args) throws IOException {
        // 차이를 최대로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //각 static 변수에 대한 초기화
        arr = new int[n];
        resList = new ArrayList<>();
        res = new ArrayList<>();
        visited = new boolean[n];

        // 배열값 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permutation(arr, n,0); //depth=0인 루트노드부터 진행
//        System.out.println(resList.size()); //확인용
//        System.out.println(resList); //확인용

        //모든 경우의 수에 대해 주어진 식의 값을 구하고, 그 중 최댓값 구하기
        int maxSub = Integer.MIN_VALUE;
        for(ArrayList<Integer> e: resList){
            int subSum = 0;
            for(int i=1;i<n;i++){
                subSum += Math.abs(e.get(i)-e.get(i-1)); //경우 하나에 대한 주어진 식의 합
            }
            if(subSum>maxSub){
                maxSub = subSum; //최댓값 갱신
            }
        }
        bw.write(maxSub+"");

        bw.flush();
        br.close();
        bw.close();
    }// main

    public static void permutation(int[] arr, int n, int depth) {
        //순열이 완성된 경우(재귀 종료 조건)
        if (depth == n) {
            resList.add(new ArrayList<>(res)); // ✅ 순열 조합 배열리스트의 요소로 res의 복사본을 추가 (아니면 아래서 res에 add, remove되는 모든 결과가 자동반영됨)
//            res = new ArrayList<>();
            return;
        }

        //0부터 n까지 반복
        for (int i = 0; i < n; i++) { //depth층마다의 모든 노드 순회
            if (!visited[i]) { //방문하지 않은 값이면 넣기
                visited[i] = true; //depth층의 i번째 값 방문처리
                res.add(arr[i]); //sub배열의 depth번 인덱스에 값 저장
                permutation(arr, n, depth + 1); //재귀호출. 다음 층으로 ㄱㄱ.
                visited[i] = false; //이 줄로 넘어왔다는 건 재귀 하나가 끝났다는 것. 이때 가장 최근에 방문햇던 노드를 방문하지 않은 걸로 갱신.
                res.remove(res.size()-1); //가장 최근에 방문했던 노드의 값을 지우기.
            }
        }
//        return; //반환값이 void면 이거 생략되어 있는 것.
    }

}

