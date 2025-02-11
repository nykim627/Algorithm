import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1부터 N^2까지의 숫자가 시계방향으로 이루어져 있는 달팽이

        int t = 4; //테스트케이스 개수 4개

        for(int tc=1;tc<=t;tc++) {

            int[][] arr = new int[2][4]; //2*4배열 {x,y,p,q} (x<p, y<q)

            //배열값 채우기
            for(int r=0;r<2;r++){
                for(int c=0;c<4;c++){
                    arr[r][c] = sc.nextInt();
                }
            }
            // {x1, y1, p1, q1} : 직사각형1
            // {x2, y2, p2, q2} : 직사각형2
            int x1 = arr[0][0]; int x2 = arr[1][0];
            int y1 = arr[0][1]; int y2 = arr[1][1];
            int p1 = arr[0][2]; int p2 = arr[1][2];
            int q1 = arr[0][3]; int q2 = arr[1][3];
            int width1 = p1-x1; int width2 = p2-x2; //직사각형 가로길이
            int len1 = q1-y1; int len2 = q2-y2; //직사각형 세로길이

            char res ; //직사각형(a), 선분(b), 점(c), 공통부분없음(d)


            //직사각형 1을 고정시켜두고 직사각형 2를 움직이면서 생각하자
            //직사각형 2의 시작을 p2=x1, q2=y1인 지점에서(또는 그 지점보다 왼쪽 아래에서...라고 하는게 더 정확하긴 함)
            if(p2<x1 || p2>x1+(width1+width2)){
                res = 'd';
            }else if(p2==x1 || p2==x1+(width1+width2)){
                if(q2<y1 || q2>y1+(len1+len2)){
                    res = 'd';
                }else if(q2==y1 || q2==y1+(len1+len2)){
                    res = 'c';
                }else{
                    res = 'b';
                }
            }else{
                if(q2<y1 || q2>y1+(len1+len2)){
                    res = 'd';
                }else if(q2==y1 || q2==y1+(len1+len2)){
                    res = 'b';
                }else{
                    res = 'a';
                }
            }

            System.out.println(res); //결과출력

        }//tc반복문 끝
    }//main끝
}