class Solution {
    public int solution(int[] arr, int idx) {
        int answer = 0;
        
        for(int i=0;i<arr.length;i++){
            if(i>=idx&&arr[i]==1){  //문제오류: 주어진 idx보다 "크거나 같으면서"여야 한다.
                answer = i;
                break;
            }else{
                answer = -1;
            }
        }
        return answer;
    }
}