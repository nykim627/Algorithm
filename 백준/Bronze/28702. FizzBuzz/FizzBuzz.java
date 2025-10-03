import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		for(int i=0;i<3;i++) {
			String str = br.readLine();
			if(!(str.equals("FizzBuzz")||str.equals("Fizz")||str.equals("Buzz"))) {
				num = Integer.parseInt(str)+(3-i);
				break;
			}
		}
		if(num%15==0) {
			System.out.println("FizzBuzz");
		}else if(num%3==0) {
			System.out.println("Fizz");
		}else if(num%5==0) {
			System.out.println("Buzz");
		}else {
			System.out.println(num);
		}
	}
}