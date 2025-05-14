import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = 0;
		double sum = 0;
		for(int i=0;i<20;i++) {
			String[] tmp = br.readLine().split(" ");
			double tmp2 = Double.parseDouble(tmp[1]);
			if(tmp[2]=="P") {
//				num--;
			}else {
				switch(tmp[2]) {
				case "A+":
					sum += tmp2 * 4.5; 
					num += tmp2;
					break;
				case "A0":
					sum += tmp2 * 4.0; 
					num += tmp2;
					break;
				case "B+":
					sum += tmp2 * 3.5; 
					num += tmp2;
					break;
				case "B0":
					sum += tmp2 * 3.0; 
					num += tmp2;
					break;
				case "C+":
					sum += tmp2 * 2.5; 
					num += tmp2;
					break;
				case "C0":
					sum += tmp2 * 2.0; 
					num += tmp2;
					break;
				case "D+":
					sum += tmp2 * 1.5; 
					num += tmp2;
					break;
				case "D0":
					sum += tmp2 * 1.0; 
					num += tmp2;
					break;
				case "F":
					sum += tmp2 * 0.0; 
					num += tmp2;
					break;

				}
			}
		}
		
		System.out.println(sum/num);

		br.close();

	}
}
