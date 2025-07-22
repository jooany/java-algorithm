class Solution {
    private int answer;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    private void dfs(int index, int total, int[] numbers, int target) {
        if (numbers.length == index) {

            if (total == target) {
                answer++;
            }
            
            return;
        }
        
        dfs(index + 1, total + numbers[index], numbers, target);
        dfs(index + 1, total - numbers[index], numbers, target);
    }
}