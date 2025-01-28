class Solution {
    public int solution(String number) {
        int tmp=0;
        for(int i=0;i<number.length();i++){
            tmp+=Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        int answer = tmp%9;
        return answer;
    }
}