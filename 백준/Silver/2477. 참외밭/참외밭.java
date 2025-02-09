import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {  //입출력 예외 처리
        Scanner sc = new Scanner(System.in);

        // 1m^2 당 참외 개수
        int k = sc.nextInt();

        // 1~4가 동서남북이므로 0~4까지의 인덱스 갖는 배열만들기
        int[] inputLen = new int[6]; //입력 순서대로의 길이 배열
        int maxEW=0; //가로길이최대
        int maxEWidx=-1; //그때의 순서(몇번째로 입력한 값인지)
        int maxSN=0; //세로길이최대
        int maxSNidx=-1; //그때의 순서

        for(int i=0;i<6;i++){ // 6번동안 움직임
            int num = sc.nextInt(); //방향입력
            int len = sc.nextInt(); //길이입력
            //기존에 저장된 값과 새로운 길이 중 최댓값 저장(같은 방향으로 두번 움직이는 경우 더 큰 값을 저장하기 위한 것)
//            inputWay[i] = num;
            inputLen[i] = len;
            if(num==1 || num==2){
                if(maxEW<len){
                    maxEW = len;
                    maxEWidx = i;
                }
            }else if(num==3||num==4){
                if(maxSN<len){
                    maxSN = len;
                    maxSNidx = i;
                }
//                maxSN = Math.max(maxSN,len);
//                maxSNidx = i;   //최댓값에 대한 인덱스를 구하고 싶으면 이렇게 하면 안됨!!!! 인덱스가 계속 갱신됨...ㅠㅠ
//                System.out.println("------SN-------");
//                System.out.println(maxSN);
//                System.out.println(maxSNidx);
//                System.out.println("-------------");
            }
        }


        // 작은 직사각형의 가로세로길이 구하기
        int minEW = 500;
        int minSN = 500;

        // 큰 직사각형의 세로에 붙어있는 가로길이의 차가 작은 직사각형의 가로 (인덱스 넘어가는 경우 주의)
        // 작은 직사각형의 가로 계산 (세로에 붙어있는 가로 길이 차이)
        if (maxSNidx == 0) {
            minEW = Math.abs(inputLen[1] - inputLen[5]); //절댓값 함수 사용
        } else if (maxSNidx == 5) {
            minEW = Math.abs(inputLen[4] - inputLen[0]);
        } else {
            minEW = Math.abs(inputLen[maxSNidx - 1] - inputLen[maxSNidx + 1]);
        }

        // 큰 직사각형의 가로에 붙어있는 세로길이의 차가 작은 직사각형의 세로 (인덱스 넘어가는 경우 주의)
        // 작은 직사각형의 세로 계산 (가로에 붙어있는 세로 길이 차이)
        if (maxEWidx == 0) {
            minSN = Math.abs(inputLen[1] - inputLen[5]);
        } else if (maxEWidx == 5) {
            minSN = Math.abs(inputLen[4] - inputLen[0]);
        } else {
            minSN = Math.abs(inputLen[maxEWidx - 1] - inputLen[maxEWidx + 1]);
        }

        // 큰/작은 직사각형의 넓이 각각 구하기
        int MaxArea = maxEW*maxSN;
        int MinArea = minEW*minSN;

//        System.out.println(maxEWidx);
//        System.out.println(maxSNidx);
//
//        System.out.println(maxEW);
//        System.out.println(minSN);
//
//        System.out.println(maxSN);
//        System.out.println(minEW);

        //결과 (총 참외 개수)
        System.out.println(k*(MaxArea-MinArea)); //참외개수 * 면적(큰직사각형-작은직사각형)
    }//main 끝
}