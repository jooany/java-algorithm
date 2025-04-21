import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int answer = 0;
        
        Arrays.sort(people);
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            
            j--;
            answer++;
        }
        
        return answer;
    }
}