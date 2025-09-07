import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.length()<3) {
			System.out.println(str);
		}else {
			int res = 99;
			for(int num=100;num<=Integer.parseInt(str);num++) {
				int start = num/100;
				int mid = (num%100)/10;
				int end = num%10;
				if(mid-start==end-mid) res++;
			}
			System.out.println(res);
		}
	}

}