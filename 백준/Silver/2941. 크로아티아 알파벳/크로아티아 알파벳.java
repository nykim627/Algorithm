import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(String e: arr){
            str = str.replace(e, "*");
        }
        System.out.println(str.length());
    }
}
