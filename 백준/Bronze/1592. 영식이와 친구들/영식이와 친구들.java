import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 첫째줄에 입력 들어옴
        int N = sc.nextInt(); //원형 자리 수 (사람 수. 인덱스를 의자번호로 활용)
        int M = sc.nextInt(); //공 M번 받으면 게임 종료
        int L = sc.nextInt(); //공던질때 시계/반시계방향 L번째 사람에게 던짐

        // 원형자리 배열
        int[] arr = new int[N+1]; //N인 의자번호도 만들어주기 위해 N+1크기로 설정
            // 현재 모두 0으로 초기화된 상태. 배열값은 각 자리의 사람이 공받은 횟수.

        boolean hasM=false; //공을 M번 받은 사람이 있는지
        int seatNum=1; //공받는 사람의 자리 번호. 1번부터 시작
        arr[1]++; //1번 횟수 +1 증가
        int total = 0; //공을 총 몇번 던지는지 -> 출력값

        // 공받기 게임
        while(!hasM && M!=1){ //공 M번 사람 없을 때. M=1이면 던질필요없음.
            //다음 공받는 사람의 자리 번호 정하기
            if(arr[seatNum]%2!=0){ //던지는사람이 현재 공받은 횟수가 홀수일때
                if(seatNum+L>N){ //시계방향(오른쪽)으로 L번째 사람에게 토스. 이때 인덱스 벗어나면
                    seatNum = (seatNum+L)%N; //의자개수로 나눈후 나온 나머지가 공받는 사람의 의자번호
                }else {
                    seatNum += L; //인덱스 안벗어나면 주는사람 의자번호+L이 공받는사람 의자번호
                }
            }else{  //던지는사람이 현재 공받은 횟수가 짝수일때
                if(seatNum-L<1){ //반시계방향(왼쪽)으로 L번째 사람에게 토스. 이때 인덱스 벗어나면
                    seatNum = N - (((seatNum-L)*(-1))%N); // 의자개수N개에서 인덱스 절대값을 의자개수로 나눈후 나온 나머지를 뺀 값이 공받는 사람의 의자번호
                }else{
                    seatNum -= L; //인덱스 안벗어나면 주는사람 의자번호-L이 공받는사람 의자번호
                }
            }//다름 번호 정하기 끝
            arr[seatNum]++; //공받은 사람 횟수 +1
            total++; //공던진 횟수 +1
            if(arr[seatNum]==M){ //공받고 바로 횟수 M인지 체크
                hasM = true; //true 나오면 반복문 끝남
            }
        }//while문 끝
        System.out.println(total);
    }//main 끝
}