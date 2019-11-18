//topo sort O(E+V)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses == 0) {
            return res;
        }
        
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        
        //change input to graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : prerequisites) {
            int pre = edge[1];
            int cur = edge[0];
            graph.get(pre).add(cur);
            indegree[cur]++;
        }
        
        //bfs
        //put all indegree == 0 into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[count] = node;
            count++;
            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        
        if (count == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
