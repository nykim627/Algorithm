import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            arrList.add(arr[i]);
        }
        //리스트에서 요소를 제거할 때 인덱스가 변하는 점을 고려하여 반복문을 뒤에서부터 진행
        for(int i=0;i<query.length;i++){
            if(i%2==0){  //query배열의 짝수 인덱스
                for(int j=arrList.size()-1;j>query[i];j--){
                    arrList.remove(j);
                }
            }else{
                for(int j=query[i]-1;j>=0;j--){
                    arrList.remove(j);
                }
            }
        }
        int[] answer = new int[arrList.size()];
        for(int i=0;i<arrList.size();i++){
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}