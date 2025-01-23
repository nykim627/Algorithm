class Solution {
    public int solution(int n, String control) {
        //int answer = 0;
        String[] arr = control.split("");
        for(String e: arr) {
        	switch(e) {
        	case "w":
        		n+=1;
        		break;
        	case "s":
        		n-=1;
        		break;
        	case "d":
        		n+=10;
        		break;
        	case "a":
        		n-=10;
        		break;
        	}
        }
        return n;
    }
}