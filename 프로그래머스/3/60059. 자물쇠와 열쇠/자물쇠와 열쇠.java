import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int M = key[0].length;
        int N = lock[0].length;
        
        int cnt = 0; //자물쇠 홈의 개수
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(lock[r][c]==0) cnt++;
            }
        }
        
        //자물쇠 상태 회전하면서 확인
        for(int d=0;d<4;d++){
            answer = lockCheck(lock, key, cnt);
            if(answer) return answer;
            lock = rotate(lock);
        }
        
        return answer;
    }
    
    public boolean lockCheck(int[][] lock, int[][] key, int cnt){
        int checkCnt = cnt;
        boolean answer = false;
        
        int M = key[0].length;
        int N = lock[0].length;
        
        for(int tc=0;tc<4;tc++){
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    answer = keyCheck(lock,r,c,key,cnt); //열쇠를 이동하면서 자물쇠와 맞는지 췤
                    if(answer) return answer;
                }
            }
            key = rotate(key); //90도 회전
        }//90도 회전 3번 + 각 파트마다 check!
        return answer;
    }
    
    public boolean keyCheck(int[][] lock, int startR, int startC, int[][] key, int cnt){
        int M = key[0].length;
        int N = lock[0].length;
        // boolean[][] visited = new boolean[N][N]; //자물쇠 중 열쇠와 만나는 부분
        
        int checkCnt = cnt;
        
        int endR = Math.min(startR+M, N);
        int endC = Math.min(startC+M, N);
        // for(int r=startR;r<endR;r++){
        //     for(int c=startC;c<endC;c++){
        //         visitied[r][c] = true;
        //     }
        // }
        for(int r=startR, keyR=0;r<endR;r++, keyR++){
            for(int c=startC, keyC=0;c<endC;c++, keyC++){
                if(key[keyR][keyC]==lock[r][c]) return false;
                if(key[keyR][keyC]==1&&lock[r][c]==0) checkCnt--;
            }
        }
        
        if(checkCnt!=0) return false;
        return true;
    }
    
    //ok!!
    public int[][] rotate(int[][] key){ 
        int M = key[0].length;
        int[][] newKey = new int[M][M];
        for(int r=0;r<M;r++){
            for(int c=0;c<M;c++){
                newKey[c][M-1-r] = key[r][c];
            }
        }
        return newKey;
    }
    
}