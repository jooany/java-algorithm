class Solution {
    private int answer;
    private int[] nums;
    private int targetNum;
    private int length;
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        targetNum = target;
        length = numbers.length;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int index, int total) {
        if (length == index) {

            if (total == targetNum) {
                answer++;
            }
            
            return;
        }
        
        dfs(index + 1, total + nums[index]);
        dfs(index + 1, total + (-1) * nums[index]);
    }
}