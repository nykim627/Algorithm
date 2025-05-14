import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int[] arr = new int[26];
			String input = br.readLine();
			boolean isGroup = true;
			if (input.length() == 1) {
				isGroup = true;
			} else {
				for (int j = 1; j < input.length(); j++) {
					if(input.charAt(j)!=input.charAt(j-1)) {
						if(arr[input.charAt(j)-'a']>=100) {
							isGroup = false;
							break;
						}else {
							arr[input.charAt(j)-'a']++;
							arr[input.charAt(j-1)-'a'] += 100;
						}
					}
				}
			}
			if(isGroup) cnt++;
		}
		System.out.println(cnt);

		br.close();

	}
}
