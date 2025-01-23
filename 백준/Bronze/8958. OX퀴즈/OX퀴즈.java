import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            String q = sc.next();
            int sum = 0;
            int tt = 0;
            for (int j = 0; j < q.length(); j++) {
                if (q.charAt(j) == 'O') {
                    sum += 1;
                } else if (q.charAt(j) == 'X') {
                    sum = 0;
                }
                tt+=sum;
            }
            System.out.println(tt);
        }
    }

}