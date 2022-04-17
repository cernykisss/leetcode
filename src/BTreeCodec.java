import java.util.LinkedList;
import java.util.Queue;

public class BTreeCodec {

    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] datas = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(root);
        int ptr = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!datas[ptr].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(datas[ptr]));
                queue.add(node.left);
            }
            ptr++;
            if (!datas[ptr].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(datas[ptr]));
                queue.add(node.right);
            }
            ptr++;
        }
        return root;
    }
}
