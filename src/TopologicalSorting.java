import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSorting {

    public int[] findOrder(int nums, int[][] dependencies) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            edges.add(new ArrayList<Integer>());
        }
        int[] inDegrees = new int[nums];
        for (int[] dependency : dependencies) {
            edges.get(dependency[1]).add(dependency[0]);
            inDegrees[dependency[0]]++;
        }
        int[] res = new int[nums];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int p = queue.poll();
            res[idx++] = p;
            for (Integer v : edges.get(p)) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) queue.add(v);
            }
        }
        if (idx != nums) return new int[0];
        return res;
    }
}
