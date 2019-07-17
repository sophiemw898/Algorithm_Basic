class Node {
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;
    int count;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
        
        head = new Node(0, 0);
        head.pre = null;
        
        tail = new Node(0, 0);
        tail.next = null;
        
        head.next = tail;
        tail.pre = head;        
    }
    
    private void deleteNode(Node node) {
        //pre > node> next
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        
        head.next.pre = node;
        head.next = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } 
        Node node = map.get(key);
        deleteNode(node);
        addToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            //move to head
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
