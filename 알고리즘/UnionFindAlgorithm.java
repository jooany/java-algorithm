import java.util.*;

class Solution {
    private static int[] parents = new int[1000];

    private static Boolean[] solution(int k, int[][] operation) {
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        ArrayList<Boolean> result = new ArrayList<>();

        for (int[] op : operation) {
            if (op[0] == 0) {
                union(op[1], op[2]);
                continue;
            }
            if (op[0] == 1) {
                result.add(equalsRoot(op[1], op[2]));
            }
        }

        return result.toArray(new Boolean[0]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        if (root1 > root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
    }

    private static Boolean equalsRoot(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        parents[x] = find(parents[x]); // 경로 압축. 루트를 찾아서 해당 노드의 부모로 저장해버린다.

        return parents[x];
    }
}