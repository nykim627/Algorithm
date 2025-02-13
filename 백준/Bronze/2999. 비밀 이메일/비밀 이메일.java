import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //정인이가 kakosi 보냄 -> 2x3 행렬에 {{k,a,k},{o,s,i}}로 들어감 -> 암호화: koaski (상근이가 받는 메시지)
        
        
        String str = sc.next(); //상근이가 받은 메시지 입력(최대 100글자)
        int n = str.length();
        
        int r = 1;
        int c = n;
        
        int tmp = 1; //반복문 내에서 증가시킬 임시 변수 만들기
        	// 이 코드 없이 r로 쓰면 마지막에 반복문 나갈때 r++이 실행돼서 기대하는 값보다 +1된 값이 나옴
        while(tmp*tmp<=n) { //root(n)까지 반복문 돌기
        	if(n%tmp==0) { //나누어 떨어지면
        		r = tmp; //나눈 값을 r에 대입
        		c = n/tmp; // 몫을 c에 대입
        	}
        	tmp++; //나누어 떨어지든 아니든 나누는 값을 1씩 더함
        }
        
//        System.out.println(r); //확인용
//        System.out.println(c);
        
        //배열에 문자 집어넣기 (행우선)
        char[][] arr = new char[c][r]; //c:행, r:열
        int idx = 0; //문자열에서 뽑을 인덱스
        for(int i=0;i<c;i++) {
        	for(int j=0;j<r;j++) {
        		arr[i][j] = str.charAt(idx++);
        	}
        }
        
        //열우선 순회 배열 읽기
        for(int j=0;j<r;j++) {
        	for(int i=0;i<c;i++) {
        		System.out.print(arr[i][j]);
        	}
        }
        
    }//main끝
}