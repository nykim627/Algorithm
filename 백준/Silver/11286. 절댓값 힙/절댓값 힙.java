import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) ->{
        	if(Math.abs(o1)==Math.abs(o2)) {
        		return o1-o2;
        	}else {
        		return Math.abs(o1)-Math.abs(o2);
        	}
        });
        for(int i=0;i<N;i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(num==0) {
        		if(pq.isEmpty()) sb.append("0\n");
        		else sb.append(pq.poll()).append("\n");
        	}else {
        		pq.offer(num);
        	}
        }
        System.out.println(sb.toString());
    }
}