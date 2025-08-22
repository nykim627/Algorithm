import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int sum = 0;
    	while(n!=0) {
    		for(int i=n;i>0;i--) {
    			sum += i;
    		}
    		System.out.println(sum);
    		sum = 0;
    		n = Integer.parseInt(br.readLine());
    	}
    }
}