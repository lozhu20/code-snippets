import java.util.HashMap;
import java.util.Map;

/**
 * @author longkun
 * @date 2022/1/17 10:10 PM
 * @description LeetCode 146. LRU 缓存
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        node = new Node(key, value);
        addToHead(node);
        cache.put(key, node);

        if (cache.size() > capacity) {
            Node tailNode = tail.prev;
            while (tailNode.prev != head && cache.size() > capacity) {
                Node toRemove = tailNode;
                tailNode = tailNode.prev;
                cache.remove(toRemove.key);
                removeNode(toRemove);
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void print() {
        Node node = head.next;
        while (node != tail) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("\n====");
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.print();

        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.print();

        lRUCache.get(1);    // 返回 1
        lRUCache.print();

        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.print();

        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.print();

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.print();

        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.print();

        lRUCache.get(3);    // 返回 3
        lRUCache.print();

        lRUCache.get(4);    // 返回 4
        lRUCache.print();

    }
}
