import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        ArrayDeque<Integer> firstQ = new ArrayDeque<>(List.of(1,2,3,4,5));
        ArrayDeque<Integer> secondQ = new ArrayDeque<>(List.of(2,1,2,3,2,4,2,5));
        ArrayDeque<Integer> thirdQ = new ArrayDeque<>(List.of(3,3,1,1,2,2,4,4,5,5));
        
        int[] cnts = new int[3];
        
        for (int answer : answers) {
            if (firstQ.peek() == answer) {
                cnts[0]++;
            }
            
            firstQ.offer(firstQ.poll());
        }
        
        for (int answer : answers) {
            if (secondQ.peek() == answer) {
                cnts[1]++;
            }
            
            secondQ.offer(secondQ.poll());
        }
        
        for (int answer : answers) {
            if (thirdQ.peek() == answer) {
                cnts[2]++;
            }
            
            thirdQ.offer(thirdQ.poll());
        }
        
        int max = 0;
        
        for (int i = 0; i < 3; i++) {
            if (max < cnts[i]) {
                max = cnts[i];
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (max == cnts[i]) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}