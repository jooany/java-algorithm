import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        PriorityQueue<String> queue = new PriorityQueue<>(
            Comparator.comparingInt((String o) -> o.charAt(n))
            .thenComparing((String o1, String o2) -> {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) < o2.charAt(i)) {
                        return -1;
                    }

                    if(o1.charAt(i) > o2.charAt(i)) {
                        return 1;
                    }
                }

                return 0;
            }));
        
        for (String s : strings) {
            queue.add(s);
        }
        
        String[] answer = new String[strings.length];
        
        for (int i = 0; i < strings.length; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}