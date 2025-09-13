import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

//방1) BFS
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        long A = Long.parseLong(nums[0]);
        long B = Long.parseLong(nums[1]); //최대 10^9
//        int[] visited = new int[B+1]; //int[B+1]면 약 4GB(≈ 4 * 10^9 bytes) 넘게 잡히니 바로 메모리 터짐
        //=> 배열 크기를 B+1로 두면 메모리 초과가 나므로, HashSet / HashMap 같은 동적 자료구조를 사용해야 함

        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{A,1});

        //방문체크는 필요없지만(첫번째경우는 항상 짝수, 두번째경우는 항상 홀수라 겹칠 수 없음)
        //안전을 위해 HashSet
        HashSet<Long> visited = new HashSet<>();
        visited.add(A);

        long ans=-1;
        while(!q.isEmpty()){
            long[] curr = q.poll();
            if(curr[0]==B){
                ans = curr[1];
            }
            //1번 경우
            if(curr[0]*2<=B && !visited.contains(curr[0]*2)){
                q.add(new long[]{curr[0]*2, curr[1]+1});
            }
            //2번 경우
            if(curr[0]*10+1<=B && !visited.contains(curr[0]*10+1)){
                q.add(new long[]{curr[0]*10+1, curr[1]+1});
            }
        }

        System.out.println(ans);
    }
}