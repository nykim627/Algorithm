//그리디, 중복순열
class Solution {
    static int userLen, emoLen;
    static int userPercent, userPrice;
    static int[] percentArr; //이모티콘 당 할인율 배열
    static int[] sales = {10,20,30,40};
    
    static int emoPlus, total;
    static int userPlus, userTotal;
    static int[] emoticons;
    static int[][] users;
    
    public int[] solution(int[][] usersArr, int[] emoticonsArr) {        
        userLen = usersArr.length;
        emoLen = emoticonsArr.length;
        emoticons = new int[emoLen];
        for(int i=0;i<emoLen;i++){
            emoticons[i] = emoticonsArr[i];
        }
        users = new int[userLen][2];
        for(int i=0;i<userLen;i++){
            for(int j=0;j<2;j++){
                users[i][j] = usersArr[i][j];
            }
        }
        
        emoPlus = -1;
        total = -1;
        
        percentArr = new int[emoLen];
        permperm(0);
        
        int[] answer = {emoPlus, total};
        
        return answer;
    }
    
    static void permperm(int idx){
        if(idx==emoLen){
            int[] tmpArr = percentArr.clone();
            int[] res = check(tmpArr);
            if(res[0]>emoPlus){
                emoPlus = res[0];
                total = res[1];
            }else if(res[0]==emoPlus){
                total = Math.max(total, res[1]);
            }
            return;
        }
        
        for(int i=0;i<4;i++){
            percentArr[idx] = sales[i];
            permperm(idx+1);
        }
    }
    
    static int[] check(int[] tmpArr){
        int userPlus = 0;
        int userTotal = 0;
        for(int u=0;u<userLen;u++){
            userPercent = users[u][0];
            userPrice = users[u][1]; 
            
            int sum = 0;
            for(int i=0;i<emoLen;i++){
                if(tmpArr[i]>=userPercent){
                    float sale = (float) tmpArr[i] / 100;
                    sum += emoticons[i]*(1-sale);
                }
            }
            // System.out.println("sum:"+sum);
            
            if(sum>=userPrice) userPlus++; //플러스 가입 하고 이모티콘 개별 구매는 x
            else userTotal+=sum; //플러스 가입 안하고 원하는 애들만 삼
            
        }
        
        return new int[]{userPlus, userTotal};
    }
}