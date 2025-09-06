import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int res = A*B*C;
		String[] str = Integer.toString(res).split("");
		int[] nums = new int[10];
		for(String e: str) {
			int num = Integer.parseInt(e);
			nums[num]++;
		}
		for(int e: nums) {
			System.out.println(e);
		}
	}

}