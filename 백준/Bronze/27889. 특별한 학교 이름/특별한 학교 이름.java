import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
/*
NLCS: North London Collegiate School
BHA: Branksome Hall Asia
KIS: Korea International School
SJA: St. Johnsbury Academy
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> hm = new HashMap<>();
        hm.put("NLCS","North London Collegiate School");
        hm.put("BHA","Branksome Hall Asia");
        hm.put("KIS","Korea International School");
        hm.put("SJA","St. Johnsbury Academy");


        String name = br.readLine();

        System.out.print(hm.get(name));
    }
}