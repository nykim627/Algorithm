import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //주어지는 자연수
        ArrayList<Integer> arrList = new ArrayList<>(); //n 이하 소수들 담는 배열
        
        for(int i=2;i<=n;i++) {
        	if(isPrime(i)) arrList.add(i);
        }
//        System.out.println(arrList);
        
        int left = 0;
        int right = 0;
        int sum = arrList.size()!=0 ? arrList.get(left) : 0; //소수 배열 크기가 0인 경우 고려해야 함!
        int size = arrList.size();
        int cnt = 0; //경우의수
        while(left<=right&&right<size) {
//        	System.out.println(left+" "+right+" "+sum);
        	if(sum==n) {
        		cnt++;
        		right++;
        		if(right<size) sum+=arrList.get(right);
        	}else if(sum<n) {
        		right++;
        		if(right<size) sum+=arrList.get(right);
        	}else {
        		if(left!=right) sum-=arrList.get(left);
        		left++;
        	}
        }
        
        
        System.out.println(cnt);
    }
    
    static boolean isPrime(int num) {
    	for(int i=2;i<=Math.sqrt(num);i++) {
    		if(num%i==0) return false;
    	}
    	return true;
    }
}