import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        String result;
        if(A+B+C!=180){
            result = "Error";
        }else if(A==60 && B==60 && C==60){
            result = "Equilateral";
        }else if(A!=B && B!=C && C!=A){
            result = "Scalene";
        }else{
            result = "Isosceles";
        }
        
        System.out.println(result);
    }
}