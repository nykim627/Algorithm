class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        if(my_string.contains(is_suffix)&&my_string.charAt(my_string.length()-1)==is_suffix.charAt(is_suffix.length()-1)){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}