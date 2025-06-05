import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack();
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				stack.pop();
			}else {
				stack.add(num);
			}
		}
		
		int sum = 0;
		for(int e: stack) {
			sum += e;
		}
		
		System.out.println(sum);

	}
}