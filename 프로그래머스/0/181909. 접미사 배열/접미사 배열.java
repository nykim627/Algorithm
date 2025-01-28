import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> arrList = new ArrayList<>();
        for(int i=0;i<my_string.length();i++){
            String tmp="";
            for(int j=i;j<my_string.length();j++){
                tmp+=my_string.charAt(j);
            }
            arrList.add(tmp);
        }
        
        arrList.sort(null); //[ABE, ACE]처럼 사전순으로 정렬 (대소문자 구분하지만 이문제는 소문자로만 이루어진 문자열)
        
        String[] arr = new String[arrList.size()];
        
        for(int i=0;i<arrList.size();i++){
            arr[i] = arrList.get(i);
        }
        
        return arr;
    }
}