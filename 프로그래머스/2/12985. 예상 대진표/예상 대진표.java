class Solution
{
    public int solution(int n, int a, int b)
    {
        for (int i = 1 ; i < n; i++) {
            if (getNextRoundNumber(a) == getNextRoundNumber(b)) {
                return i;
            }
            
            a = getNextRoundNumber(a);
            b = getNextRoundNumber(b);
        }

        return 0;
    }
    
    private int getNextRoundNumber(int num) {
        if (num % 2 == 0) {
            return num / 2;
        }
        
        return (num + 1) / 2;
    }
}