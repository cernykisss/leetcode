import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {}

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size, capacity;
    private LinkedNode head = new LinkedNode();
    private LinkedNode tail = new LinkedNode();
    private Map<Integer, LinkedNode> keyToNodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = keyToNodeMap.get(key);
        if (node == null) return -1;
        updateExistedNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode oldNode = keyToNodeMap.get(key);
        if (oldNode == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            keyToNodeMap.put(key, newNode);
            insertNodeTohead(newNode);
            size++;
            if (size > capacity) {
                LinkedNode removeTailNode = removeTailNode();
                keyToNodeMap.remove(removeTailNode.key);
                size--;
            }
        } else {
            oldNode.value = value;
            updateExistedNode(oldNode);
        }
    }

    private void updateExistedNode(LinkedNode node) {
        // remove node from its current position
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // insert after head
        insertNodeTohead(node);
    }

    private void insertNodeTohead(LinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private LinkedNode removeTailNode() {
        LinkedNode newTailNode = tail.pre.pre;
        LinkedNode removedNode = newTailNode.next;
        newTailNode.next = tail;
        tail.pre = newTailNode;
        return removedNode;
    }
}
