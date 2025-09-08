import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<M;i++) {
			String[] orders = br.readLine().split(" ");
			switch(orders[0]) {
			case "add":
				int num1 = Integer.parseInt(orders[1]);
				if(!set.contains(num1)) set.add(num1);
				break;
			case "remove":
				int num2 = Integer.parseInt(orders[1]);
				if(set.contains(num2)) set.remove(num2);
				break;
			case "check":
				int num3 = Integer.parseInt(orders[1]);
				if(set.contains(num3)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				int num4 = Integer.parseInt(orders[1]);
				if(set.contains(num4)) set.remove(num4);
				else set.add(num4);
				break;
			case "all":
				for(int num5=1;num5<=20;num5++) {
					set.add(num5);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.println(sb.toString());
	}

}