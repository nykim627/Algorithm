class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String ans = "";
        ans = my_string.substring(0,s)+overwrite_string;
        if(ans.length()==my_string.length()){
            answer = ans;
        }else{
            answer = ans+my_string.substring(ans.length(),my_string.length());
        }
        return answer;
    }
}