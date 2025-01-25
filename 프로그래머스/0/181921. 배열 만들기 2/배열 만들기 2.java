import java.util.ArrayList;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int cnt=0;
        for(int i=l;i<=r;i++){
            if((Integer.toString(i).contains("0")||Integer.toString(i).contains("5"))&&(!(Integer.toString(i).contains("1")||Integer.toString(i).contains("2")||Integer.toString(i).contains("3")||Integer.toString(i).contains("4")||Integer.toString(i).contains("6")||Integer.toString(i).contains("7")||Integer.toString(i).contains("8")||Integer.toString(i).contains("9")))){
                arrList.add(i);
                cnt++;
            }
        }
        if(cnt==0){
            arrList.add(-1);
        }
        // ArrayList를 int[]로 변환
        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }

        return result;
    }
}