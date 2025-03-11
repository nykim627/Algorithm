// 문제: 백준 4358번 생태학
// 메모리: KB
// 시간: ms

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Integer> map = new TreeMap<>();
        int cnt=0; //전체 나무 수
        String str = "";
        while((str = br.readLine())!=null && !str.isEmpty()){
            map.put(str,map.getOrDefault(str,0)+1);
            cnt++;
        }

//        while(true){
//            String str = br.readLine();
//            if(str==null || str.isEmpty())break;
//            else{
//                map.put(str.strip(),map.getOrDefault(str,0)+1);
//                cnt++;
//            }
//        }

        for(String e: map.keySet()){
            float tmp = Math.round(((float)map.get(e)/cnt)*1000000)/(float)10000.0;
            System.out.print(e+" ");
            System.out.printf("%.4f\n",tmp);
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

}
