import java.util.ArrayList;

class Solution {
    public int[] solution(int x) {
        ArrayList<Integer> arrList = new ArrayList<>();
        
        arrList.add(x);
        while(x!=1){
            if(x%2==0){
                x/=2;
            }else{
                x = 3*x+1;
            }
            arrList.add(x);
        }
        
        // ArrayList를 int[]로 변환
        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }
        
        return result;
    }
}