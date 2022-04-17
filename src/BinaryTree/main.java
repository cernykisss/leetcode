package BinaryTree;

import org.junit.Test;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
    }
    @Test
    public void testss() {
        int[] datas = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Node> nodes = createBinTree.create(datas);
        ArrayList<Integer> integers = Travesal.dfsStack(nodes.get(0));
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
