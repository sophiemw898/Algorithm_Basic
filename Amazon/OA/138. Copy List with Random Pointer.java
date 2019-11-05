//No extra spave
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        
        //clone all nodes
        // A - A' - B - B'- C - C'
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            
            node = node.next.next;
        }
        
        //clone all random 
        node = head;
        while (node!= null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
        //seperate two NodeList 
        //A - A' - B - B'- C - C' to A-B-C A'-B'-C'
        node = head;
        Node newNode = head.next;
        Node dummy = newNode;
        while (node != null) {
            node.next = node.next.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            } else {
                newNode.next = null;
            }
            
            node = node.next;
            newNode = newNode.next;
        }
        
        return dummy;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
Approach 2: Iterative with O(N) Space
class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {        
        if (head == null) {
            return null;
        }

        Node node = cloneNode(head);
        Node dummy = new Node(0);
        dummy.next = node;
      
        while (head != null) {
            node.next = cloneNode(head.next);
            node.random = cloneNode(head.random);
            
            head = head.next;
            node = node.next;
        }
        
        return dummy.next;
    }
    
    private Node cloneNode(Node node) {
        //Map<Node, Node> map = new HashMap<>();
        //map can't be updated each time
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        } else {
            map.put(node, new Node(node.val, null, null));
            return map.get(node);
        }
    }
}

//recursion 
//use the map to record if the current node has been copied
//need to updated during recursion, put it outsite 
class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        if (map.containsKey(head)) {
            return map.get(head);
        }
        
        Node node = new Node(head.val, null, null);
        map.put(head, node);
        
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        
        return node;
    }
}
