class MyHashMap {
    
    Entry[] nodes = new Entry[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = indexFor(key);
        if (nodes[index] == null) {
            nodes[index] = new Entry(-1, -1);
        }
        Entry prev = findPrev(nodes[index], key);
        if (prev.next == null) {
            prev.next = new Entry(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = indexFor(key);
        if (nodes[index] == null) {
            return -1;
        }
        Entry node = findPrev(nodes[index], key);
        return node.next == null ? -1 : node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = indexFor(key);
        if (nodes[index] == null) {
            return;
        }
        Entry node = findPrev(nodes[index], key);
        if (node.next == null) {
            return;
        }
        node.next = node.next.next;       
    }
    
     //Returns index for hash code h.
    int indexFor(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    //find the prev entry which next key is key or null
    private Entry findPrev(Entry bucket, int key) {
        Entry node = bucket;
        Entry prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    class Entry {
        int key;
        int val;
        Entry next;
        
        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
