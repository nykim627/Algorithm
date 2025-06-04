import java.util.*;
import java.io.*;

public class Main{
	public static class Person{
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Person> list = new ArrayList();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Person p = new Person(age, name);
			list.add(p);
		}
		
		Collections.sort(list, (cur, pos)->{
			return cur.age-pos.age;
		});
		
		StringBuilder sb = new StringBuilder();
		for(Person e: list) {
			sb.append(e.age).append(" ").append(e.name).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}