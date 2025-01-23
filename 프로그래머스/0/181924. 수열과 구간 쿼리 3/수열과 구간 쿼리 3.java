class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int k=0;k<queries.length;k++) {
        	int i = queries[k][0];
        	int j = queries[k][1];
        	int arr_i = arr[i];
        	int arr_j = arr[j];
        	arr[i] = arr_j;
        	arr[j] = arr_i;
        }
        return arr;
    }
}