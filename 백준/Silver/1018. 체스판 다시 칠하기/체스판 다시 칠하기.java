import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[N][M];
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
        	for(int j=0;j<M;j++) {
        		arr[i][j] = str.charAt(j);
        	}
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=N-8;i++) {
        	for(int j=0;j<=M-8;j++) {
        		int cntA = 0;
        		int cntB = 0;
        		//WBWB...인 경우 (A)
        		for(int row=i;row<i+8;row++) {
        			for(int col=j;col<j+8;col++) {
        				if((row+col)%2==0 && arr[row][col]!='W') {
        					cntA++;
        				}else if((row+col)%2==1 && arr[row][col]!='B') {
        					cntA++;
        				}
        			}
        		}
        		//BWBW...인 경우 (B)
        		for(int row=i;row<i+8;row++) {
        			for(int col=j;col<j+8;col++) {
        				if((row+col)%2==0 && arr[row][col]!='B') {
        					cntB++;
        				}else if((row+col)%2==1 && arr[row][col]!='W') {
        					cntB++;
        				}
        			}
        		}
//        		System.out.println(cntA);
//        		System.out.println(cntB);
//        		System.out.println(min);
        		min = Math.min(min,  Math.min(cntA, cntB));
        		
        	}
        }
        
        System.out.println(min);
    }
}