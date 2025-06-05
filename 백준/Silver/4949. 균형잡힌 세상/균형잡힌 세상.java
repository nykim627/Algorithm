import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack;
		String tmp = br.readLine();
		HashMap<Character, Character> map = new HashMap();
		map.put('(', ')');
		map.put('[', ']');
		while(!tmp.equals(".")) {
			stack = new Stack();
			boolean isVPS = true;
			for(int j=0;j<tmp.length();j++) {
				if(tmp.charAt(j)=='(' || tmp.charAt(j)=='[') {
					stack.add(tmp.charAt(j));
				}else if(tmp.charAt(j)==')' || tmp.charAt(j)==']') {
					if(stack.isEmpty()) {
						isVPS = false;
					}else {
						char pop = stack.pop();
						if(tmp.charAt(j)!=map.get(pop)) isVPS=false;
					}
				}else {
					continue;
				}
			}
			if(stack.size()==0 && isVPS) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
			tmp = br.readLine();
		}
		
		System.out.println(sb.toString());

	}
}