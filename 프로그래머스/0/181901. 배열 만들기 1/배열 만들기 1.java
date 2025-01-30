import java.util.ArrayList; 
class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(i%k==0){
                arrList.add(i);
            }
        }
        
        int[] answer = new int[arrList.size()];
        for(int i=0;i<arrList.size();i++){
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}