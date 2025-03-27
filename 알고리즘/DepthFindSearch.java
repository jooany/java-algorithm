import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

class DepthFindSearch {
    private static String[] solution() {
        int n = 6;
//        String[][] graph = new String[][]{{"1", "2"}, {"2", "3"}, {"3", "4"}, {"4", "5"}};
        String[][] graph = new String[][]{{"1", "2"}, {"1", "3"}, {"2", "4"}, {"2", "5"}, {"3", "6"}, {"5", "6"}};
        String start = "1";

        LinkedHashSet<String> visited = new LinkedHashSet<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        ArrayList<String>[] nodeGraph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodeGraph[i] = new ArrayList<>();
        }

        for (String[] edges : graph) {
            nodeGraph[Integer.parseInt(edges[0])]
                    .add(edges[1]);
        }

        stack.push(start);

        while (!stack.isEmpty()) {
            String curr = stack.pop();

            if (!visited.contains(curr)) {
                visited.add(curr);
            }

            for (String adjacent : nodeGraph[Integer.parseInt(curr)]) {
                if (!visited.contains(adjacent)) {
                    stack.push(adjacent);
                }
            }
        }

        return visited.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution()));
    }
}