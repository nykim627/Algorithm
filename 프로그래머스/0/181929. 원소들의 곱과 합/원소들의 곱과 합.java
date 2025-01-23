class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        int mul = 1;
        for (int e:num_list){
            sum+=e;
            mul*=e;
        }
        if (mul<sum*sum){
            answer=1;
        }else if(mul>sum*sum){
            answer=0;
        }
        return answer;
    }
}