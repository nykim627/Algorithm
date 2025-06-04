import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = 5;
        int[] arr = new int[N];
        
        int sum = 0;
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        System.out.println(sum/5);
        System.out.println(arr[2]);
        
    }
}