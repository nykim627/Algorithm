import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=intervals[0][0];i<=intervals[0][1];i++){
            arrList.add(arr[i]);
        }
        for(int i=intervals[1][0];i<=intervals[1][1];i++){
            arrList.add(arr[i]);
        }
        int[] answer = new int[arrList.size()];
        for(int i=0;i<arrList.size();i++){
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}