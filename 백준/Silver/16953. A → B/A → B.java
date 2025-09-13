import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

//방2) 그리디 : B->A로 가기
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        long A = Long.parseLong(nums[0]);
        long B = Long.parseLong(nums[1]); //최대 10^9

        long steps = 1;
        while(B>A){
            if(B%2==0){
                B /= 2;
                steps++;
            }else if(B%10==1){
                B = (B-1)/10;
                steps++;
            }else{
                steps = -1;
                break;
            }
        }
        System.out.println(A==B ? steps : -1); //A==B이어야만 steps가 의미있음
    }
}