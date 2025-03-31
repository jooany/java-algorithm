import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : road) {
            graph[edge[0]].add(new Node(edge[1], edge[2]));
            graph[edge[1]].add(new Node(edge[0], edge[2]));
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.offer(new Node(1, 0));
        dist[1] = 0;
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            // 현재 노드가 최단 거리 갱신된 상태가 아니면 스킵
            if (dist[curr.value] < curr.cost) continue;

            for (Node adjacent : graph[curr.value]) {
                int newDist = dist[curr.value] + adjacent.cost;
                
                if (newDist < dist[adjacent.value]) {
                    dist[adjacent.value] = newDist;
                    queue.offer(new Node(adjacent.value, newDist));
                }
            }
        }
        
        return (int) Arrays.stream(dist)
            .filter(d -> d <= K)
            .count();
    }
    
    private static class Node {
        int value, cost;
        
        Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }
}
