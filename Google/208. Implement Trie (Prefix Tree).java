class TrieNode {

    boolean isEnd;
    TrieNode[] nodes;
    
    TrieNode() {
        nodes = new TrieNode[26];
    }
    
    public boolean containsKey(char c) {
        return nodes[c - 'a'] != null;
    }
    
    public void put(char c, TrieNode node) {
        nodes[c - 'a'] = node;
    }
    
    public TrieNode get(char c) {
        return nodes[c - 'a'];
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public void setEnd() {
        isEnd = true;
    }
}

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
       root = new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr)) {
                node.put(curr, new TrieNode());
            } 
            node = node.get(curr);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (node.containsKey(curr)) {
                node = node.get(curr);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curr = prefix.charAt(i);
            if (node.containsKey(curr)) {
                node = node.get(curr);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
