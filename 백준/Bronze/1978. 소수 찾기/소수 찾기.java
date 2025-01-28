import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            // 소수면 cnt++
            int k=2;
            while(k!=0){
                if(a==1){
                    k=0;
                }else if(a%k==0){
                    if(a/k==1){
                        cnt++;
                        k=0;
                    }else{
                        k=0; //소수 아님
                    }
                }else{
                    k++;
                }
            }
        }
        System.out.println(cnt);

    }
}