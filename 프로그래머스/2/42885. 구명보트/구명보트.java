import java.util.*;

//P42885 구명보트
//한 구명보트당 최대 2명만 탑승 가능.
//덱에 내림차순 정렬한 상태로 넣고 앞뒤로 꺼낸다.
//앞+뒤 합한게 무게제한보다 작으면 둘 다 뺀다 (구명보트 완성)
//아니라면 가장 무거운 앞사람만 뺀다 (구명보트 완성)
class Solution {
    public int solution(int[] people, int limit) {
        int N = people.length;
        Arrays.sort(people);
        Deque<Integer> deque = new LinkedList();
        for(int i=N-1;i>=0;i--){
            deque.add(people[i]);
        }
        
        int answer = 0;
        while(!deque.isEmpty()){
            int first = deque.peekFirst();
            int last = deque.peekLast();
            if(first+last<=limit){
                deque.pollFirst();
                deque.pollLast();
                answer++;
            }else{
                deque.pollFirst();
                answer++;
            }
        }
        
        return answer;
    }
}