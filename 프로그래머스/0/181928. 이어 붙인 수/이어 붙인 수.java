class Solution {
    public static int solution(int[] num_list) {
        int answer = 0;
        String sum_odd="";
        String sum_even="";
        for(int e: num_list){
            if(e%2==0){
                sum_even+=e;
            }else{
                sum_odd+=e;
            }
        }
        answer = Integer.parseInt(sum_even)+Integer.parseInt(sum_odd);
        return answer;
    }
}