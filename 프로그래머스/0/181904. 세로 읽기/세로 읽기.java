import java.util.ArrayList;

class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        //ArrayList<String> arrList = new ArrayList<>();
        String[] arr = new String[my_string.length()/m];
        
        int idx = 0;
        for(int i=0;i<my_string.length();i+=m){
            arr[idx++] = my_string.substring(i,i+m);
        }
        
        for(String e: arr){
            answer += e.charAt(c-1);
        }
        
        return answer;
    }
}