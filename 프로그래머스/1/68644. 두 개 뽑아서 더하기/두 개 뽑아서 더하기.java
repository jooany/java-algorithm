import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> answer = new HashSet<Integer>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j <numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }
}