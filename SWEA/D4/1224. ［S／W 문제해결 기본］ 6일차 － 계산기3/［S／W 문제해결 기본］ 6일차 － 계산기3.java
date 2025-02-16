import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 10; //tc 개수


        int cnt = 0; // 0이 아닌 칸과 0칸이 만나는 변의 개수

        for(int tc=1;tc<=t;tc++){ //tc반복

            int len = sc.nextInt(); // 문자열 길이
            String infix = sc.next(); // 연산해야 하는 문자열 (괄호의 유효성 여부는 항상 옳은 경우만 주어짐, 피연산자인 숫자는 한자리수만 주어짐)

            Map<Character, Integer> priority = new HashMap<>(); //스택 내에서의 우선순위 기준
            priority.put('(',0);
            priority.put('+',1);
            priority.put('-',1);
            priority.put('*',2);
            priority.put('/',2);

            StringBuilder postfix = new StringBuilder(); //후위연산으로 변환 후 수식

            //연산자를 담는 스택
            Stack<Character> op = new Stack<>();

            for(int i=0;i<infix.length();i++){
                if(infix.charAt(i)=='('){ //여는 괄호 처리
                    op.push(infix.charAt(i));
                }
                else if(infix.charAt(i)==')'){ //닫는 괄호 처리
                    //여는 괄호 만날때까지 꺼내고, 버린다.
                    while(op.peek()!='('){
                        postfix.append(op.pop());
                    }
                    op.pop(); //top이 가리키는 여는 소괄호 버리기
                }
                //피연산자(한자리)
                else if(infix.charAt(i)>='0' && infix.charAt(i)<='9'){
                    postfix.append(infix.charAt(i));
                }
                //연산자
                else{
                    //공백O
                    if(op.isEmpty())
                        op.push(infix.charAt(i));
                    else{
                        //연산자 우선순위를 비교해서 처리
                        while(priority.get(op.peek())>=priority.get(infix.charAt(i)) && !op.isEmpty()){
                            postfix.append(op.pop());
                        }
                        op.push(infix.charAt(i));
                    }
                }
            }//중위표기를 하나씩 읽어서 처리

            //중위표기를 다 읽은 후에도 스택에 남아 있는 연산자를 비워서 후위 표기법 완성
            while(!op.isEmpty()){
                postfix.append(op.pop());
            }
            //System.out.println(postfix);

            //////////////계산
            Stack<Integer> calc = new Stack<>(); //숫자를 담을 스택
            for(int i=0;i<postfix.length();i++){
                //피연산자라면
                if(postfix.charAt(i)>='0' && postfix.charAt(i)<='9'){
                    calc.push(postfix.charAt(i)-'0'); //'0'-'0'=0
                }
                //연산자라면
                else{
                    //꺼내는 순서 중요
                    int B = calc.pop();
                    int A = calc.pop();

                    switch (postfix.charAt(i)){
                        case '+':
                            calc.push(A+B);
                            break;
                        case '-':
                            calc.push(A-B);
                            break;
                        case '*':
                            calc.push(A*B);
                            break;
                        case '/':
                            calc.push(A/B);
                            break;
                    }
                }
            }//후위계산 for문

            //결과 출력
            int ans = calc.pop();
            System.out.println("#"+tc+" "+ans);
        }//tc순회끝

        sc.close();
    }//main끝
}