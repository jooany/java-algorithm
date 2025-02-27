import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answerPatternOfFirst = new int[] {1,2,3,4,5};
        int[] answerPatternOfSecond = new int[] {2,1,2,3,2,4,2,5};
        int[] answerPatternOfThird = new int[] {3,3,1,1,2,2,4,4,5,5};
        
        int[] markedAnswer = new int[3];
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < answers.length; i++) {
            markAnswer(markedAnswer, answers, answerPatternOfFirst, i, 0);
            markAnswer(markedAnswer, answers, answerPatternOfSecond, i, 1);
            markAnswer(markedAnswer, answers, answerPatternOfThird, i, 2);
        }
        
        Integer max = Arrays.stream(markedAnswer).max().orElse(1);        
        for (int i = 0; i < markedAnswer.length; i++) {
            if (max == markedAnswer[i]) {
                result.add(i + 1);
            }
        }
        
        return result.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private void markAnswer(int[] markedAnswer, int[] answers, int[] answerPattern, int i, Integer key) {
        if (answers[i] != answerPattern[i % answerPattern.length]) {
            return;
        }
        
        markedAnswer[key]++;
    }
}