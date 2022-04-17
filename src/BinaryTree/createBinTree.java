package BinaryTree;

import java.util.ArrayList;

public class createBinTree {

    public static ArrayList<Node> create(int[] datas) {

        ArrayList<Node> nodes = new ArrayList<>();

        for (int data : datas) {
            Node node = new Node(data);
            nodes.add(node);
        }

        for (int index = 0; index < nodes.size()/2 - 1; index++) {
            nodes.get(index).setLeft(nodes.get(index * 2 + 1));
            nodes.get(index).setRight(nodes.get(index * 2 + 2));
        }

        int index = nodes.size()/2 - 1;
        nodes.get(index).setLeft(nodes.get(index * 2 + 1));
        if (nodes.size() % 2 == 1) {
            nodes.get(index).setRight(nodes.get(index * 2 + 2));
        }
        return nodes;
    }
}
