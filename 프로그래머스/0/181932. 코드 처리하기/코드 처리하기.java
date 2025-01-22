class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        String[] arr = code.split("");
        for(int i=0;i<arr.length;i++) {
        	if(mode==0) {
        		if(!arr[i].equals("1")) {
            		if(i%2==0) {
            			answer+=arr[i];
            		}
            	}else {
            		mode = 1;
            	}
        	}else {
        		if(!arr[i].equals("1")) {
            		if(i%2==1) {
            			answer+=arr[i];
            		}
            	}else {
            		mode = 0;
            	}
        	}
        	
        }
        
        if(answer.equals("")) {
        	return "EMPTY";
        }else {return answer;}
        
    }
}