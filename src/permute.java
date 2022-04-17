import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class permute {

    List<List<Integer>> res = new ArrayList<>();
    @Test
    public void main() {
        permute(new int[] {1,2,3});
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<Integer>(), used);
        return res;
    }
    void dfs(int[] nums, int depth, List<Integer> path, boolean[] used) {
        if (depth == nums.length) {
//            System.out.println(path);
            res.add(path);
            System.out.println(res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
//            不允许重复元素：当前元素与上一个元素相等且上一个元素没有使用过
//            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]))
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
