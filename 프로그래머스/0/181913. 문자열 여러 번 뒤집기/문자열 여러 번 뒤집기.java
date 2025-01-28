class Solution {
    public String solution(String my_string, int[][] queries) {
        //String answer = "";
        for(int i=0;i<queries.length;i++){
            String tmp = "";
            for(int j=0;j<queries[i][0];j++){
                tmp+=my_string.charAt(j);
            }
            for(int k=queries[i][1];k>=queries[i][0];k--){
                tmp+=my_string.charAt(k);
            }
            for(int l=queries[i][1]+1;l<my_string.length();l++){
                tmp+=my_string.charAt(l);
            }
            my_string = tmp;
        }
        return my_string;
    }
}