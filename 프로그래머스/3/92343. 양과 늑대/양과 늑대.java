import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        ArrayList<Integer>[] tree = buildTree(info, edges);
        
        int answer = 0;
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(0, 1, 0, new HashSet<>()));
        
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(answer, now.sheep);
            now.visited.addAll(tree[now.node]); // 현재 방문 노드에, 현재노드의 이웃 노드 리스트를 그대로 추가한다.
            
            // 인접한 노드들에 대해 탐색
            for (int next : now.visited) {
                // 기존 해시셋의 데이터를 복사하고, 현재 방문한 정점을 해시셋에서 제거한다.
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
                
                if (info[next] == 1) { // 늑대일 경우
                    if (now.sheep != now.wolf + 1) {
                        queue.offer(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else { // 양일 경우
                    queue.offer(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        
        return answer;
    }
    
    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited; 
        }
    }
    
    private ArrayList<Integer>[] buildTree(int[] info, int[][] edges) {
        ArrayList<Integer>[] tree = new ArrayList[info.length];
        
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
        
        return tree;
    }
}