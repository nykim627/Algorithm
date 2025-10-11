import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        int res = 0;
        for(int i=0;i<arr.length;i++){
            int subSum = 0;
            
            //각 그룹 내부의 + 처리
            String[] numArr = arr[i].split("\\+"); //+는 정규식에서 특수문자이므로 이스케이프 처리
            for(String e: numArr){
                subSum += Integer.parseInt(e);
            }
            
            if(i==0) res += subSum;
            else res -= subSum;
        }
        System.out.println(res);
    }
    
}