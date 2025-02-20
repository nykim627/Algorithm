import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Solution {
    public static char[] tree = new char[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 10; //tc 개수

        for(int tc=1;tc<=t;tc++){ //tc반복

            int n = sc.nextInt(); //트리가 갖는 정점의 총수
            sc.nextLine(); //이것이 문제였도다....!!!
            String[][] arr = new String[n+1][4]; // [0]정점번호 [1]트리값
            tree = new char[n+1];

            //정점 정보 입력받기
            for(int i=1;i<=n;i++){
                String str = sc.nextLine();
                String[] tmpArr = str.split(" ");
                int tmp = Integer.parseInt(tmpArr[0]);
                tree[tmp] = tmpArr[1].charAt(0);

            }

            //결과출력
//            System.out.println(Arrays.toString(tree));
            System.out.print("#"+tc+" ");
            inOrder(1);
            System.out.println();


        }//tc순회끝

        sc.close();
    }//main끝


    static void inOrder(int v){
        if(v < tree.length){ //재귀탈출조건
            //왼쪽자식 탐방
            inOrder(v*2);
            //방문처리
            if(tree[v]!='\u0000'){
                System.out.print(tree[v]);
            }
            //오자 탐방
            inOrder(v*2+1);
        }
    }



}