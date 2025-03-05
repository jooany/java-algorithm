import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        char[] result = new char[n];
        Arrays.fill(result, 'O');
        
        Deque<Node> removed = new ArrayDeque<>();
        Node root = new Node(0);
        Node prev = root;
        Node selected = root;
        
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            prev.next = node;
            node.prev = prev;
            prev = node;
            if (i == k) selected = node;
        }

        for (String c : cmd) {
            char word = c.charAt(0);
            
            if (word == 'U') {
                for (int i = 0; i < Integer.valueOf(c.substring(2)); i++) {
                    selected = selected.prev;
                }
            } else if (word == 'D') {
                for (int i = 0; i < Integer.valueOf(c.substring(2)); i++) {
                    selected = selected.next;
                }
            } else if (word == 'C') {
                removed.push(selected);
                
                if (selected.prev != null) selected.prev.next = selected.next;
                if (selected.next != null) selected.next.prev = selected.prev;
                
                selected = selected.next != null ? selected.next : selected.prev;
                
            } else if (word == 'Z') {
                Node restoredNode = removed.pop();
                
                if (restoredNode.prev != null) restoredNode.prev.next = restoredNode;
                if (restoredNode.next != null) restoredNode.next.prev = restoredNode;
            }
        }
        
        while (!removed.isEmpty()) {
            result[removed.pop().index] = 'X';
        }
        
        return String.valueOf(result);
    }
    
    static class Node {
        int index;
        Node prev, next;
        
        Node(int index) {
            this.index = index;
        }
    }
}