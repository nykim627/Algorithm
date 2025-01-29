import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String my_string = sc.next();

        int[] answer = new int[26];

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<my_string.length();j++){
                if(my_string.charAt(j)==i+97){  //a~z: 97~122
                    answer[i]=j;
                    break;
                }
                answer[i]=-1;
            }
        }
        //System.out.println(Arrays.toString(answer));

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
    }
}