//O(N)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            res.add(0);
            return res;
        }
        if (edges.length == 1) {
            res.add(edges[0][0]);
            res.add(edges[0][1]);
            return res;
        }
        //create the graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        //find all leaves and remove 
        //then remove leaves level by level until just one or two node left.
        //then it is the result root
        List<Integer> leaves = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while (n > 2) {
            //remove the leaves
            n -= leaves.size();
            
            //update their neighbors
            //find new leaves
            List<Integer> nextLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                for (int nei : graph.get(leaf)) {
                    graph.get(nei).remove(leaf);
                    if (graph.get(nei).size() == 1) {
                        nextLeaves.add(nei);
                    }
                }
            }
            
            leaves = nextLeaves;            
        }
        
        return leaves;
    }
}

//超时
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            res.add(0);
            return res;
        }
        if (edges.length == 1) {
            res.add(edges[0][0]);
            res.add(edges[0][1]);
            return res;
        }
        //create the graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        int[] paths = new int[n];
        int min = n;
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() > 1) {
                paths[i] = getLength(graph, i);
                //System.out.println(i + "''" + paths[i]);
                if (paths[i] < min) {
                    min = paths[i];
                }
            } 
        }
        for (int i = 0; i < n; i++) {
            if (paths[i] == min) {
                res.add(i);
            }
        }
        return res;
    }
    //use bfs to get the longth path from point node
    private int getLength(List<Set<Integer>> graph, int node) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int nei : graph.get(curr)) {
                    if (!set.contains(nei)) {
                        queue.offer(nei);
                        set.add(nei);
                    }
                }
            }
        }
        
        return ans;
    }
}
