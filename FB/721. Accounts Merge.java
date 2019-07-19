//做graph， 找连通器
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                if (!graph.containsKey(email)) {
                    graph.put(email, new ArrayList<>());
                }
                if (i == 1) {
                    continue;
                }
                graph.get(email).add(account.get(1));
                graph.get(account.get(1)).add(email);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        Set<String> isVisited = new HashSet<>();
        for (String email : emailToName.keySet()) {
            if (!isVisited.contains(email)) {
                isVisited.add(email);
                Stack<String> stack = new Stack<>();
                List<String> component = new ArrayList<>();
                stack.push(email);
                while (!stack.empty()) {
                    String str = stack.pop();
                    component.add(str);
                    for (String neighbor : graph.get(str)) {
                        if (!isVisited.contains(neighbor)) {
                            stack.push(neighbor);
                            isVisited.add(neighbor);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        
        return ans;
    }
}
