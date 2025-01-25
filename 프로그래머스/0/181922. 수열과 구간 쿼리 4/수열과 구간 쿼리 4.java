class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int[] arr2 : queries){
            for(int i=arr2[0];i<=arr2[1];i++){
                if (i % arr2[2] == 0) {
                    arr[i]+=1;
                }
            }
        }

        return arr;
    }
}