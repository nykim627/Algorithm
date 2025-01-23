import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        System.out.println((v-a)%(a-b)==0 ? (v-a)/(a-b)+1 : (v-a)/(a-b)+2);
    }
}