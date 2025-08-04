import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//가장 최적화된 코드
class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	Deque<Integer> dq = new LinkedList();
    	for(int tc=0;tc<T;tc++) {
    		String[] orders = br.readLine().split(" ");
    		switch(orders[0]) {
    		case "push_front":
    			dq.offerFirst(Integer.parseInt(orders[1]));
    			break;
    		case "push_back":
    			dq.offerLast(Integer.parseInt(orders[1]));
    			break;
    		case "pop_front":
    			if(dq.isEmpty()) sb.append("-1\n");
    			else {
    				int curr = dq.pollFirst();
    				sb.append(curr).append("\n");
    			}
    			break;
    		case "pop_back":
    			if(dq.isEmpty()) sb.append("-1\n");
    			else {
    				int curr = dq.pollLast();
    				sb.append(curr).append("\n");
    			}
    			break;
    		case "size":
    			sb.append(dq.size()).append("\n");
    			break;
	    	case "empty":
	    		if(dq.isEmpty()) sb.append("1\n");
	    		else sb.append("0\n");
	    		break;
	    	case "front":
	    		if(dq.isEmpty()) sb.append("-1\n");
	    		else {
	    			int curr = dq.peekFirst();
	    			sb.append(curr).append("\n");
	    		}
	    		break;
	    	case "back":
	    		if(dq.isEmpty()) sb.append("-1\n");
	    		else {
	    			int curr = dq.peekLast();
	    			sb.append(curr).append("\n");
	    		}
	    		break;
    		}
    		
    	}//tc
    	
    	System.out.println(sb.toString());
    }

}