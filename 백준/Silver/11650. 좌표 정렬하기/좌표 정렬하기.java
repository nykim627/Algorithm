//문제번호: 11650
//메모리:
//시간:ms

import java.io.*;
import java.util.*;


public class Main {

    static class Plane implements Comparable<Plane>{ //내부적으로 클래스를 정의해서 만들어보자. (A형 이상의 문제는 이렇게 푸는 경우 많음!!)
        int x;
        int y;

        public Plane(int x, int y){ //파라미터 생성자
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Plane{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override //비교기준 세우기
        public int compareTo(Plane o) { //x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
            if(this.x==o.x){
                return  this.y - o.y;
            }else{
                return this.x - o.x;
            }
        }
    }//Plane 클래스 정의 끝!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //좌표 정렬

        ArrayList<Plane> planes = new ArrayList<>(); //Plane을 요소로 갖는 배열리스트 생성 (삽입/삭제보다 조회를 더 많이 할 예정이므로)

        int n = Integer.parseInt(br.readLine()); //점 개수 (1 ≤ N ≤ 100,000)

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) { //단어 길이가 같은 경우
                return o1.compareTo(o2); //문자열 오름차순 정렬(객체에 대한 기본 정렬기준 이용)
            } else { //다른 경우
                return o1.length() - o2.length(); //길이 기준 오름차순 정렬
            }
        });

        //값 입력 후 객체를 리스트에 추가
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Plane p1 = new Plane(x,y);
            planes.add(p1);
        }

        //정렬하기
        Collections.sort(planes); //Plane 클래스에서 구현한 비교기준대로 정의됨!

        //결과 출력
        int size = planes.size();
        for(Plane e: planes){
            bw.write(e.x+" "+e.y+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
