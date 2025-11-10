import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        /*
            최대한 무게가 많이 나가는 사람과 적게 나가는 사람을 짝 지어야 한다.
        */
        
        int answer = 0;
        int len = people.length;
        Arrays.sort(people);
        
        int p1 = 0;
        int p2 = len - 1;
        
        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) {
                p1++;
                p2--;
            } else {
                p2--;
            }
            
            answer++;
        }
        
        return len - p2 - 1;
    }
}