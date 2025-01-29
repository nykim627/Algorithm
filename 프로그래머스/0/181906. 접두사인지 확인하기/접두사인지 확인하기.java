import java.util.ArrayList;

class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        ArrayList<String> arrList = new ArrayList<>();

        for(int i=1;i<=my_string.length();i++){
            arrList.add(my_string.substring(0,i));
        }

        if(arrList.contains(is_prefix)){
            answer = 1;
        }else{
            answer = 0;
        }
        
        return answer;
    }
}