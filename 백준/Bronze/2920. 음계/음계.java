import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for(int i=0;i<8;i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        for(int i=0;i<8;i++) {
            if(arr[i]==i+1){
                cnt+=1;
            }else if(arr[i]==8-i){
                cnt-=1;
            }
        }
        if(cnt==8){
            System.out.println("ascending");
        }else if(cnt==-8){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }

    }

}