class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;
        int[] arr = new int[2*N];
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0;i<N;i++){
            arr[i] = queue1[i];
            arr[i+N] = queue2[i];
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
        }
        int left = 0;
        int right = N-1;
        long goal = (sum1+sum2)%2==0 ? (sum1+sum2)/2 : -1;
        boolean flag = false;
        int answer = 0;
        // System.out.println(goal);
        while(left<2*N && right<2*N && goal!=-1){
            if(sum1==goal){
                flag = true;
                // System.out.println("== : "+left+" "+right+" | "+sum1);
                break;
            }else if(sum1<goal){
                //right 움직이고 합에 더하기
                right++;
                if(right>=2*N) break;
                sum1 += right>=N ? queue2[right-N] : queue1[right];
                answer++;
                // System.out.println("< : "+left+" "+right+" | "+sum1);
            }else{
                //미리 합에서 빼고 left 움직이기
                if(left>=2*N) break;
                sum1 -= left>=N ? queue2[left-N] : queue1[left];
                left++;
                answer++;
                // System.out.println("> : "+left+" "+right+" | "+sum1);
            }
        }
        
        if(!flag) answer = -1;
        return answer;
    }
}