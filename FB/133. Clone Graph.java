//dfs

//Use HashMap to look up nodes and add connection to them while performing BFS.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        //1.use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<Node> nodes = getNodes(node);
        
        //2. copy nodes, store the old->new mapping information in a hash map
        Map<Node, Node> map = new HashMap<>();
        for (Node curr : nodes) {
            map.put(curr, new Node(curr.val));
        }
        
        //3. copy edges(neighbors)
        for (Node curr : nodes) {
            map.get(curr).neighbors = new ArrayList<>();
            for (Node neighbor : curr.neighbors) {
                Node newNeighbor = map.get(neighbor);
                map.get(curr).neighbors.add(newNeighbor);
            }
        }
            
        return map.get(node);
    }
    
    private ArrayList<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        //bfs 不需要分层 全部遍历就好
        while (!queue.isEmpty()) {
            //int size = queue.size();
            //for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                for (Node neighbor : curr.neighbors) {
                    if (!set.contains(neighbor)) {
                        set.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            //}
        }
        return new ArrayList<Node>(set);
    }
}
