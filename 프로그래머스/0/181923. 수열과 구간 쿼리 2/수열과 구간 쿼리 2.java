class Solution {
    public int[] solution(int[] arr, int[][] queries) {
    	int[] answer = new int[queries.length];
        for(int k=0;k<queries.length;k++) {
        	int min = 1000000;
        	for(int s=queries[k][0];s<=queries[k][1];s++) {
        		if(arr[s]>queries[k][2]) {
        			if(arr[s]<min) {
        				min=arr[s];        				
        			}
        		}else {
        			continue;
        		}
        	}
        	answer[k]= (min==1000000) ? -1 : min;
        }
        return answer;
    }
}