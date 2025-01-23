import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int[][] arr = new int[h][w];

            String first = Integer.toString(n%h==0 ? h : n%h);
            String last = "";
            if(n%h==0){
                last = n/h<10 ? "0"+Integer.toString(n/h) : Integer.toString(n/h);
            }else {
                last = n / h + 1 < 10 ? "0" + Integer.toString(n / h + 1) : Integer.toString(n / h + 1);
            }
            System.out.println(first+last);
        }



    }

}