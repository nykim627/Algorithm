import java.io.*;
import java.util.StringTokenizer;

//B11723 근손실
//
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order){
                case "add":
                    int x1 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x1))==0) S = S | (1<<x1);
                    break;
                case "remove":
                    int x2 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x2))!=0) S = S & ~(1<<x2);
                    break;
                case "check":
                    int x3 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x3))!=0) bw.write(1+"\n");
                    else if((S&(1<<x3))==0) bw.write(0+"\n");
                    break;
                case "toggle":
                    int x4 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x4))!=0) S = S & ~(1<<x4);
                    else if((S&(1<<x4))==0) S = S | (1<<x4);
                    break;
                case "all":
                    S = ~S^S;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

}
