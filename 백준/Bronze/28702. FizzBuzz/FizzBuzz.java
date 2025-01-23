import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        String a1 = sc.next();
        if(a1.equals("FizzBuzz")){
            String a2 = sc.next();
            String a3 = sc.next();
            System.out.println("Fizz");
        }else if(a1.equals("Fizz")){
            String a2 = sc.next();
            String a3 = sc.next();
            if(a2.equals("Buzz")){
                System.out.println("Fizz");
            }else {
                int a4 = Integer.parseInt(a2)+2;
                if(a4%5==0){
                    System.out.println("FizzBuzz");
                }else{
                    System.out.println("Fizz");
                }
            }
        }else if(a1.equals("Buzz")){
            String a2 = sc.next();
            String a3 = sc.next();
            if(a2.equals("Fizz")){
                System.out.println(Integer.parseInt(a3) + 1);
            }else {
                int a4 = Integer.parseInt(a2)+2;
                if(a4%3==0){
                    System.out.println("Fizz");
                }else{
                    System.out.println(a4);
                }
            }
        }else{
            String a2 = sc.next();
            String a3 = sc.next();
            int a4 = Integer.parseInt(a1)+3;
            if(a4%5==0){
                System.out.println("Buzz");
            }else{
                System.out.println(a4);
            }
        }
    }
}