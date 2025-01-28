import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> arrList = new ArrayList<>();

        for(String e: intStrs){
            String tmp = "";
            for(int i=s;i<s+l;i++){
                tmp+=e.charAt(i);
            }
            if(Integer.parseInt(tmp)>k){
                arrList.add(Integer.parseInt(tmp));
            }
        }

        int[] arr = new int[arrList.size()];
        for(int i=0;i< arrList.size();i++){
            arr[i] = arrList.get(i);
        }
        return arr;
    }
}