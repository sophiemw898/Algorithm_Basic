//check input
// in seqs, empty? 0? org.length + 1?
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        //corner case [1] [] seqs is empty
        // if (seqs == null || seqs.size() == 0) {
        //     return false;
        // }
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        //change to graph   
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new HashSet<>());
                indegree.putIfAbsent(seq.get(i), 0);

                if (i > 0) {
                    if (!graph.get(seq.get(i - 1)).contains(seq.get(i))) {
                        indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                    }
                    graph.get(seq.get(i - 1)).add(seq.get(i));
                }
            }
        }

        if (indegree.size() != org.length) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int node = queue.poll();
            if (org[count++] != node) {
                return false;
            }
            
            for (int nei : graph.get(node)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }
        
        return count == org.length;
    }
}
