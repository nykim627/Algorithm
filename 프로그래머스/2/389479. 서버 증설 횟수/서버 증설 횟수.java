class Solution {
    public int solution(int[] players, int m, int k) {
        int N = players.length;
        // System.out.println(N);
        int[] cnt = new int[24];
        for(int i=0;i<24;i++){
            cnt[i] = players[i]/m;
            // System.out.print(cnt[i]+" ");
        }
        
        int pointer = 0;
        // System.out.println();
        int servers = 0;
        while(pointer<N){
            // System.out.print(pointer+" ");
            if(cnt[pointer]<=0) {
                pointer++;
                continue;
            }else{
                servers = cnt[pointer];
                for(int i=pointer+1;i<pointer+k;i++){
                    if(i>=N) continue;
                    cnt[i] -= servers;
                }
                pointer++;
            }
        }
        // System.out.println();
        
        int answer = 0;
        for(int i=0;i<24;i++){
            // System.out.print(cnt[i]+" ");
            if(cnt[i]>0) answer+= cnt[i];
        }
        
        return answer;
    }
}