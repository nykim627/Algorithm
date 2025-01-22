class Solution {
    public int solution(int a, int b) {
        int answer = 0;
       
        String ab = Integer.toString(a)+b; //String.valueOf(a)도 가능
        String ba = Integer.toString(b)+a;
        if (Integer.valueOf(ab) >= Integer.valueOf(ba)){ //Integer.parseInt()도 가능
            answer = Integer.valueOf(ab);
        }else{
            answer = Integer.valueOf(ba);
        }
        return answer;
    }
}