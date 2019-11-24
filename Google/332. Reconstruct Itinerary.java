class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) {
            return res;
        }
        
        //create the graph
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            if (!graph.containsKey(start)) {
                graph.put(start, new ArrayList<>());
            }
            graph.get(start).add(end);
        }
        
        //sort the arrival
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }
        
        helper(graph, "JFK", 0, tickets.size(), res);
        return res;
    }
    
    private boolean helper(Map<String, List<String>> graph, String curr, int step, int n,  List<String> res) {
        res.add(curr);
        
        if (res.size() == n + 1) {
            return true;
        }
        if (!graph.containsKey(curr) || graph.get(curr).isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < graph.get(curr).size(); i++) {
            String nei = graph.get(curr).get(i);
            graph.get(curr).remove(i);
            
            if (helper(graph, nei, step, n, res)) {
                return true;
            }
            
            res.remove(res.size() - 1); // backtrack
            graph.get(curr).add(i, nei);
        }
                
        return false;
    }
}
