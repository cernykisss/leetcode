package BinaryTree;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Travesal {

    static ArrayList<Integer> values = new ArrayList<>();

    public static ArrayList<Integer> preorderTraversal(Node node) {
        if (node == null) {
            return null;
        }
        values.add(node.getValue());
        preorderTraversal(node.getLeft());
        preorderTraversal(node.getRight());
        return values;
    }

    public static ArrayList<Integer> inorderTraversal(Node node) {
        if (node == null) {
            return null;
        }
        inorderTraversal(node.getLeft());
        values.add(node.getValue());
        inorderTraversal(node.getRight());
        return values;
    }

    public static ArrayList<Integer> postorderTraversal(Node node) {
        if (node == null) {
            return null;
        }
        postorderTraversal(node.getLeft());
        postorderTraversal(node.getRight());
        values.add(node.getValue());
        return values;
    }

    public static ArrayList<Integer> dfsRecursive(Node node) {
        if (node == null) {
            return null;
        } else {
            values.add(node.getValue());
        }
        dfsRecursive(node.getLeft());
        dfsRecursive(node.getRight());
        return values;
    }

    public static ArrayList<Integer> bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        if (node != null) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            node = queue.poll();
            values.add(node.getValue());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
                LinkedList<Integer> linkedList = new LinkedList<>();
            }
        }
        return values;
    }

    public static ArrayList<Integer> dfsStack(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            values.add(node.getValue());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        return values;
    }


    //双分支节点个数
    public static Integer DsonNodes(Node node) {
        if (node == null) return null;
        if (node.getLeft() != null && node.getRight() != null) {
            return (DsonNodes(node.getLeft()) + DsonNodes(node.getRight()) + 1);
        } else {
            return (DsonNodes(node.getLeft()) + DsonNodes(node.getRight()));
        }
    }

    //交换左右子树 镜像
    public static Node swapLRSons(Node root) {
        if (root == null) return null;
        Node temp = root.getLeft();
        root.setLeft(swapLRSons(root.getRight()));
        root.setRight(swapLRSons(temp));
        return root;
    }

    //判断完全二叉树
    public static boolean judgeFullBTree (Node node) {
        if (node == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int count = 1;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.getValue() != count) return false;
            count++;
            if (node.getLeft() != null) queue.add(node.getLeft());
            if (node.getRight() != null) queue.add(node.getRight());
        }
        return true;
    }

    //通过inorder preorder确定二叉树
    public static Node conPreIn(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        Node root = new Node(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.setLeft(conPreIn(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i)));
                root.setRight(conPreIn(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length)));
                break;
            }
        }
        return root;
    }

    //公共节点
    public static Node getCommonNode(Node head, Node n1, Node n2) {
        if (head == null) return null;
        if (head.getValue() == n1.getValue() || head.getValue() == n2.getValue()) return head;
        Node p1 = getCommonNode(head.getLeft(), n1, n2);
        Node p2 = getCommonNode(head.getRight(), n1, n2);
        if (p1 != null || p2 != null) return head;
        return p1 == null? p2: p1;
    }

    //二叉树最大深度
    public static Integer maxDepth(Node root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());
        return 1 + Integer.max(leftDepth, rightDepth);
    }

    //二叉树最大宽度
    public static Integer maxWidth(Node node) {
        if (node == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int maxLength = 0;
        while (true) {
            int len = queue.size();
            if (len == 0) break;
            while (len > 0) {
                Node temp = queue.poll();
                len--;
                if (temp.getLeft() != null) queue.add(temp.getLeft());
                if (temp.getRight() != null) queue.add(temp.getRight());
            }
            maxLength = Math.max(maxLength, queue.size());
        }
        return maxLength;
    }

    //二叉树叶节点连城单链表
    private static Node pre, head;
    public static Node connetChilds(Node root) {
        if (root == null) return null;
        connetChilds(root.getLeft());
        if (root.getLeft() == null && root.getRight() == null) {
            if (pre == null) {
                pre = root;
                head = root;
            }
            else {
                pre.setRight(root);
                pre = root;
            }
        }
        connetChilds(root.getRight());
        pre.setRight(null);
        return head;
    }

    //判断二叉树相似
    public static boolean similar(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        else {
            boolean left = similar(root1.getLeft(), root2.getLeft());
            boolean right = similar(root1.getRight(), root2.getRight());
            return left && right;
        }
    }

    //判断二叉搜索树
    private static long pre_val = Long.MIN_VALUE;
    public static Boolean isValidBST(Node root) {
        if (root == null) return true;
        if (!isValidBST(root.getLeft())) return false;
        if (root.getValue() < pre_val) return false;
        pre_val = root.getValue();
        return isValidBST(root.getRight());
    }

    //数据在bst中的层次
    public static Integer level(Node root, int target) {
        if (root == null) return 0;
        int level = 1;
        while (root.getValue() != target) {
            if (target > root.getValue()) root = root.getRight();
            if (target < root.getValue()) root = root.getLeft();
            level++;
        }
        return level;
    }

    //判断平衡二叉树
    public static boolean isBalanced(Node node) {
        if (node == null) return true;
        int left = maxDepth(node.getLeft());
        int right = maxDepth(node.getRight());
        return (Math.abs(left - right) < 2 && isBalanced(node.getLeft()) && isBalanced(node.getRight()));
    }

    //二叉排序树从大到小输出大于k的值
    public static void outPut(Node node, int k) {
        if (node == null) return;
        if (node.getRight() != null) outPut(node.getRight(), k);
        if (node.getValue() >= k) System.out.println(node.getValue());
        if (node.getLeft() != null) outPut(node.getLeft(), k);
    }

    @Test
    public void test() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
//        LinkedList<Integer> queue = new LinkedList<>();
//
//        queue.addFirst(1);
//        queue.addFirst(2);
//        int[] a = {1,2,3};
//        System.out.println(a[-1]);
//        System.out.println(queue.poll());
        ArrayList<Integer> integers1 = new ArrayList<>(integers);
        for (Integer integer : integers1) {
            System.out.println(integer);
        }
    }
}
