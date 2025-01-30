class Solution {
    public String solution(String my_string, int[] indices) {
        // indices 배열 정렬
        for(int i=0;i<indices.length-1;i++){
            for(int j=i+1;j<indices.length;j++){
                if(indices[i]>indices[j]){
                    int tmp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = tmp;
                }
            }
        }

        // indices 배열에 없는 글자만 answer에 붙이기
        String answer = "";
        for(int i=0;i<my_string.length();i++){
            int cnt=0;
            for(int e: indices){
                if(i==e) {
                    cnt++;
                }
            }
            if(cnt==0){
                answer+=my_string.charAt(i);
            }
        }
        return answer;
    }
}