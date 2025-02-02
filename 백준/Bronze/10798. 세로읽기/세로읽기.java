import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[15][5];  

        for(int i=0;i<5;i++){
            String[] arr2 = sc.next().split("");
            for(int j=0;j<arr2.length;j++){
                arr[j][i] = arr2[j];
            }
        }

        String str = "";
        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++){
                if(arr[i][j]!=null){
                    str += arr[i][j];
                }
            }
        }
        System.out.println(str);

    }
}