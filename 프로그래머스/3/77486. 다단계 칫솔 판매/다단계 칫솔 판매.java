import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Node> nodeMap = new HashMap<>();
        Node root = new Node(-1);
        
        for (int i = 0 ; i < enroll.length; i++) {
            nodeMap.put(enroll[i], new Node(i, enroll[i], nodeMap.getOrDefault(referral[i], root)));
        }
        
        for (int i = 0; i < amount.length; i++) {
            Node sellerNode = nodeMap.get(seller[i]);
            
            addPayOffForParent(sellerNode, amount[i] * 100, answer);
        }
        
        return answer;
    }
    
    private void addPayOffForParent(Node curr, int payOff, int[] answer) {
        if (curr.prev == null) {
            return;
        }
        
        if (payOff * 0.1 < 1) {
            answer[curr.index] += payOff;
            return;
        }
        
        answer[curr.index] += Math.ceil(payOff * 0.9);
        
        addPayOffForParent(curr.prev, (int) Math.floor(payOff * 0.1), answer);
    }
    
    private static class Node {
        int index;
        String name;
        Node prev;
        
        public Node (int index) {
            this(index, null, null);
        }
        
        public Node (int index, String name, Node prev) {
            this.index = index;
            this.name = name;
            this.prev = prev;
        }
    }
}