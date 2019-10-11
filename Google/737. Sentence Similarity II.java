class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            if (!map.containsKey(pair.get(0))) {
                map.put(pair.get(0), new HashSet<>());
            }
            if (!map.containsKey(pair.get(1))) {
                map.put(pair.get(1), new HashSet<>());
            }
            
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
            // System.out.println(pair.get(0));
            // System.out.println(pair.get(1));
        }
        
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if (w1.equals(w2)) {
                continue;
            }
            if (!map.containsKey(w1)) {
                return false;
            }
            //check if there is a path from w1 to w2
            if (!dfs(map, w1, w2, new HashSet<>())) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        if (graph.get(source).contains(target)) {
            return true;
        }
        
        if (visited.contains(source)) {
            return false;
        }
        
        visited.add(source);
        for (String neighbor : graph.get(source)) {
            if (!visited.contains(neighbor) && dfs (graph, neighbor, target, visited)) {
                return true;
            }
        }
        
        return false;
    }
}
