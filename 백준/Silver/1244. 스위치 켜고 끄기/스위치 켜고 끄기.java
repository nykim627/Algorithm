import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //입력 위한 스캐너 객체 생성
		
		//첫째 줄에 스위치 개수 주어짐(100이하 양의 정수)
		int N = sc.nextInt();
		
		//둘째줄: 각 스위치 상태 배열 (인덱스 헷갈리지 않도록 0번 스위치 있다고 가정)
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();  //스위치 상태 저장
		}
		
		//셋째줄: 학생 수
		int stuNum = sc.nextInt();
		
		//학생마다 성별+받은수 입력 후 스위치 조작
		for(int i=0;i<stuNum;i++) {
			//학생 상태 입력받음 (ex. 2 3)
			int sex = sc.nextInt(); //학생성별
			int num = sc.nextInt(); //받은 수
			
			//스위치 조작
			if(sex==1) { //남자
				for(int j=1;j<=N;j++) {  //스위치 번호
					if(j%num==0) {
						arr[j] = arr[j]==0 ? 1 : 0;  //삼항연산자 이용. j가 0이면 1로 아니면 0으로 전환
					}
				}	
			}else { //여자
				arr[num] = arr[num]==0 ? 1 : 0;  //일단 본인 상태 먼저 바꿈
				
				//양쪽 배열탐색
				for(int left=num, right=num;;) {  //left, right는 num에서 양쪽으로 넘어가는 인덱스
					if(left>1&&right<N) { //left 주의. 0번째 스위치는 없다고 쳐야함.
						left--; right++; //양쪽으로 인덱스 옮겨!
						if(arr[left]==arr[right]) { // 양쪽 스위치 상태 같으면 각 스위치 상태 전환
							arr[left] = arr[left]==0 ? 1 : 0;
							arr[right] = arr[right]==0 ? 1 : 0;
						}else {
							break;   //연속구간 조건 성립 안하므로 실행 멈춤
						}
					}else { //무한입력이 생긴다면 while문에서 이상한 부분을 찾아보자
						break; //else없으면 -> if조건에 한번도 맞지 않으면 계속 반복문 돌아감
					}
				}//양쪽 배열탐색 끝
			}//여자 끝
		}//학생마다 스위치 조작 끝남
		
		//모든 실행 이후 최종 스위치 상태 출력(한줄에 20개씩)
		for(int i=1;i<=N;i++) {
			System.out.print(arr[i]+" ");  //스위치 상태 출력(1부터N까지)
			if(i%20==0) {
				System.out.println();
			}
		}
		sc.close();
	}//main끝
}
