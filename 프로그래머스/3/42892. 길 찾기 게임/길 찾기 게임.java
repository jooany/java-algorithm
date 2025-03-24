import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = getNodes(nodeinfo);
        
        Node root = nodes[0];
        
        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            
            while (true) {
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        
        // 전위순회
        ArrayList<Integer> preOrderAnswer = new ArrayList<>();
        preOrder(root, preOrderAnswer);
        
        // 후위순회
        ArrayList<Integer> postOrderAnswer = new ArrayList<>();
        postOrder(root, postOrderAnswer);
        
        return new int[][] {
            preOrderAnswer.stream().mapToInt(Integer::valueOf).toArray(), 
            postOrderAnswer.stream().mapToInt(Integer::valueOf).toArray()
            };
    }
    
    private static void preOrder (Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }
    
    private static void postOrder (Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }
    
    private Node[] getNodes(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
              return o1.x - o2.x;  
            }
            
            return o2.y - o1.y;
        });
        
        return nodes;
    }
    
    private static class Node {
        int x, y, num;
        Node left, right;
        
        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}