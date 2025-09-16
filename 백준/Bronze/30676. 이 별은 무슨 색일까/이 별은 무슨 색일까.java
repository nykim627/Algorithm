import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 빨간색: 620nm 이상 780nm 이하
주황색: 590nm 이상 620nm 미만
노란색: 570nm 이상 590nm 미만
초록색: 495nm 이상 570nm 미만
파란색: 450nm 이상 495nm 미만
남색: 425nm 이상 450nm 미만
보라색: 380nm 이상 425nm 미만
 */
class Main {
	static int[] nums = {1,2,3};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n>=620 && n<=780) System.out.println("Red");
		else if(n>=590) System.out.println("Orange");
		else if(n>=570) System.out.println("Yellow");
		else if(n>=495) System.out.println("Green");
		else if(n>=450) System.out.println("Blue");
		else if(n>=425) System.out.println("Indigo");
		else if(n>=380) System.out.println("Violet");
		
	}

}