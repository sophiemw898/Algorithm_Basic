class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }
        
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!findCycle(graph, color, i)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    //default white 0; gray 1; black -1
    private boolean findCycle(int[][] graph, int[] color, int node) {
        
        color[node] = 1;
        for (int nei : graph[node]) {
            //black means all its child has been checked and no cycle
            if (color[nei] == -1) {
                continue;
            }
            //grey means it has been gone on the same path, has cycle
            if (color[nei] == 1) {
                return true;
            }
            //white then continue to check
            if (findCycle(graph, color, nei)) {
                return true;
            }  
        }
        
        color[node] = -1;
        return false;   
    }
}
