class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String str1 = equation.get(0);
            String str2 = equation.get(1);
            map.putIfAbsent(str1, new HashMap<>());
            map.putIfAbsent(str2, new HashMap<>());
            map.get(str1).put(str2, values[i]);
            map.get(str2).put(str1, 1/values[i]);
        }
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1), map, new HashSet<>(), 1);
        }
        
        return res;
    }
    
    private double dfs(String start, String end, Map<String, Map<String, Double>> map, 
                    Set<String> visited, double product) {
        if (!map.containsKey(start)) {
            System.out.println(start);
            return -1.0;
        }
        if (start.equals(end)) {
            return product;
        }
        
        visited.add(start);
        
        for (String nei : map.get(start).keySet()) {
            if (visited.contains(nei)) {
                continue;
            }
            double res = dfs(nei, end, map, visited, product * map.get(start).get(nei));
            if (res != -1.0) {
                return res;
            }
        }
        
        return -1.0;
    }
}
