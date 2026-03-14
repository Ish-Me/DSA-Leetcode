class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }
    void deleteNode(Node delNode) {
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }
    public int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key);
            int res = resNode.val;
            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            m.put(key, head.next);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node existingNode = m.get(key);
            m.remove(key);
            deleteNode(existingNode);
        }
        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        m.put(key, head.next);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */