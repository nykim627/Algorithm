import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        System.out.print(":fan::fan::fan:\n" +
                ":fan::");
        System.out.print(name);
        System.out.println("::fan:\n" +
                ":fan::fan::fan:");
    }
}