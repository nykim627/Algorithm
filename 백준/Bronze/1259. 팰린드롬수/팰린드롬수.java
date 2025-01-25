import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int k = 1;
        while(k!=0){
            String n = sc.next();
            if(n.equals("0")){
                k=0;
            }else{
                String s2 = "";

                for(int i=0;i<n.length();i++){
                    s2 += n.charAt((n.length()-1)-i);
                }
//                System.out.println(n);
//                System.out.println(s2);

                System.out.println(n.equals(s2) ? "yes" : "no");
            }

        }

    }
}