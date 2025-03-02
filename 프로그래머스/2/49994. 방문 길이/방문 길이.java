import java.util.*;

class Solution {
    public int solution(String dirs) {

        // 일단 먼저, 도달할 수 있는 점을 자료구조로 저장해둔다.
        Set<Set<List<Integer>>> resultSet = new HashSet<>();
        
        Integer[] point = new Integer[] {0, 0};
        Integer[] nextPoint = new Integer[] {0, 0};
        char[] dirArr = dirs.toCharArray();
        for (int i = 0; i < dirArr.length; i++) {
            if (dirArr[i] == 'U' && point[1] < 5) {
                nextPoint[1]++;
            }
            
            if (dirArr[i] == 'D' && point[1] > -5) {
                nextPoint[1]--;
            }
            
            if (dirArr[i] == 'R' && point[0] < 5) {
                nextPoint[0]++;
            }
            
            if (dirArr[i] == 'L' && point[0] > -5) {
                nextPoint[0]--;
            }
            
            if (nextPoint[0] == point[0] && nextPoint[1] == point[1]) {
                continue;
            }
            
            Set<List<Integer>> pointSet = new HashSet<>();
            pointSet.add(Arrays.asList(point));
            pointSet.add(Arrays.asList(nextPoint));
            
            resultSet.add(pointSet);
            
            point[0] = nextPoint[0];
            point[1] = nextPoint[1];
        }

        return resultSet.size();
    }
}