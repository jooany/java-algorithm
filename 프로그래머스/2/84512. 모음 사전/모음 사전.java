class Solution {
    static String[] alphabets;
    static String inputWord;
    static int answer;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    
    public int solution(String word) {
        alphabets = new String[]{"A", "E", "I", "O", "U"};
        inputWord = word;
        cnt = -1;
        
        search();
        
        return answer;
    }
    
    private static void search() {
        cnt++;
        
        if (sb.length() != 0 && sb.toString().equals(inputWord)) {
            answer = cnt;
            return;
        }
        
        if (sb.length() == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            sb.append(alphabets[i]);
            search();
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}