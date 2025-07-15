class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (prices[i] > prices[j]) {
                    answer[i]++;
                    break;
                }
                
                if (prices[i] == prices[j]) {
                    answer[i] += answer[j] + 1;
                    break;
                }
                
                if (prices[i] < prices[j]) {
                    answer[i]++;
                }
            }
        } 
        
        return answer;
    }
}