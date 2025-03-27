import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class Dijkstra {
    private static int[] solution(int start, int[][] graph, int n) {
        ArrayList<Node>[] adjacents = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacents[i] = new ArrayList<>();
        }

        for (int[] edges : graph) {
            adjacents[edges[0]].add(new Node(edges[1], edges[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];


        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            if (visited[curr.num]) {
                continue;
            }

            visited[curr.num] = true;

            for(Node adjacent : adjacents[curr.num]) {
                if (dist[adjacent.num] > curr.cost + adjacent.cost) {
                    dist[adjacent.num] = curr.cost + adjacent.cost;
                    queue.offer(new Node(adjacent.num, dist[adjacent.num]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                        solution(0,
                                new int[][]{{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}},
                                3)
                )
        );
        System.out.println(Arrays.toString(
                        solution(0,
                                new int[][]{{0, 1, 1}, {1, 2, 5}, {2, 3, 1}},
                                4)
                )
        );
    }

    private static class Node {
        int num, cost; // 여기서 cost는 출발노드로부터의 비용임.

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
