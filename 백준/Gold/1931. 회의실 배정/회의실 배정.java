import java.util.*;
import java.io.*;

/*
끝나는 시간이 빠른 회의를 우선 선택하면 남은 시간에 더 많은 회의를 배치 가능. 
끝나는 시간 오름차순 정렬 후 겹치지 않는 회의만 선택. 
O(N log N) - 최적 솔루션
*/
class Main{
    public static class Meeting implements Comparable<Meeting>{
        int start, end;
        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o){
            if(this.end==o.end) return this.start-o.start;
            return this.end-o.end;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> arrList = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrList.add(new Meeting(start, end));
        }
        
        Collections.sort(arrList);
        
        int meetingCnt = 0;
        int endTime = 0;
        
        for(Meeting e: arrList){
            if(e.start >= endTime){
                meetingCnt++;
                endTime = e.end;
            }
        }
        
        System.out.println(meetingCnt);
    }
}