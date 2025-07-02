import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // 정렬하기 위한 배열
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
            int[] curr = commands[i];
            
            for (int j = curr[0] - 1; j < curr[1]; j++) {
                list.add(array[j]);
            }
            
            Collections.sort(list);
            
            answer[i] = list.get(curr[2] - 1);
            
            list.clear();
        }
        
        return answer;
    }
}