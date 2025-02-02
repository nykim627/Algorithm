class Solution {
    public int solution(int[] num_list) {
        boolean cnt = false;
        int answer = 0;
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]<0){
                answer = i;
                cnt = true;
                break;
            }
        }
        if(!cnt){
            answer=-1;
        }
        return answer;
    }
}