import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class BreadthFirstSearch {
    private static int[] solution(int start, int[][] graph, int n) {
        ArrayList<Integer>[] adjacents = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjacents[i] = new ArrayList<>();
        }

        for (int[] edges : graph) {
            adjacents[edges[0]].add(edges[1]);
        }

        LinkedHashSet<Integer> visited = new LinkedHashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Integer adjacent : adjacents[curr]) {
                if (visited.contains(adjacent)) {
                    continue;
                }
                queue.offer(adjacent);
                visited.add(adjacent);
            }
        }

        return visited.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                        solution(1,
                                new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}},
                                9)
                )
        );

        System.out.println(Arrays.toString(
                        solution(1,
                                new int[][]{{1, 3}, {3, 4}, {3, 5}, {5, 2}},
                                5)
                )
        );
    }
}
