import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> arrList = new ArrayList<>();
        switch(n){
            case 1:
                for(int i=0;i<=slicer[1];i++){
                    arrList.add(num_list[i]);
                }
                break;
            case 2:
                for(int i=slicer[0];i<num_list.length;i++){
                    arrList.add(num_list[i]);
                }
                break;
            case 3:
                for(int i=slicer[0];i<=slicer[1];i++){
                    arrList.add(num_list[i]);
                }
                break;
            case 4:
                for(int i=slicer[0];i<=slicer[1];i+=slicer[2]){
                    arrList.add(num_list[i]);
                }
                break;
        }
        int[] answer = new int[arrList.size()];
        for(int i=0;i< arrList.size();i++){
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}