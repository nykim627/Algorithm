import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = {"","","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		String input = br.readLine();
		int sum = 0;
		for(int i=0;i<input.length();i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[j].contains(Character.toString(input.charAt(i)))) {
					sum += j;
				}
			}
			
		}
		
		System.out.println(sum);
		
		br.close();

	}
}
