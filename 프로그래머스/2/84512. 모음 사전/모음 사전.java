class Solution {
    String[] alphabets;
    String inputWord;
    int answer, cnt = 0;
    
    public int solution(String word) {
        alphabets = new String[]{"A", "E", "I", "O", "U"};
        inputWord = word;
        
        search(new StringBuilder());
        
        return answer;
    }
    
    private void search(StringBuilder sb) {
        if (sb.length() > 0) {
            cnt++;
            
            if (sb.toString().equals(inputWord)) {
                answer = cnt;
                return;
            }
        }
        
        if (sb.length() == 5) return;
        
        for (int i = 0; i < 5; i++) {
            sb.append(alphabets[i]);
            search(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}