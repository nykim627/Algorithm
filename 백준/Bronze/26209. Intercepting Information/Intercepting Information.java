import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] str = br.readLine().split(" ");
    	boolean hasNine = false;
    	for(String e:str) {
    		if(e.equals("9")) {
    			hasNine = true;
    		}
    	}
    	System.out.println(hasNine ? "F" : "S");
    }
}