import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int j=0;j<str.length();j++){
                char tmp = str.charAt(j);
                if(tmp=='(') stack.push(tmp);
                else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    } else{
                        stack.pop();
                    }
                }
            }
            if(flag && stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}