class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(int i=0;i<my_string.length();i++){
            int cnt = 0;
            for(int j=65;j<=90;j++){
                if(my_string.charAt(i)==j){
                    answer[j-65]++;
                }
            }
            for(int j=97;j<=122;j++){
                if(my_string.charAt(i)==j){
                    answer[j-71]++;
                }
            }
        }
        return answer;
    }
}