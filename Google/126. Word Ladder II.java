class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return results;
        }
        
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }
        dict.add(beginWord);
        if (!dict.contains(endWord)) {
            return results;
        }
        
        List<String> path = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        bfs(graph, distance, endWord, beginWord, dict);//输出每个点到end的距离
        dfs(graph, distance, beginWord, endWord, results, path);//从start出发dfs
        
        return results;
    }
    
    private void dfs(Map<String, List<String>> graph, Map<String, Integer> distance, 
                String curr, String end, List<List<String>> results, List<String> path) {
                    path.add(curr);
                    if (curr.equals(end)) {
                        results.add(new ArrayList<String>(path));
                        // //path.remove(path.size() - 1);
                        // return;
                    }
                    for (String nextWord : graph.get(curr)) {
                        if (distance.containsKey(nextWord) && 
                            distance.get(nextWord) + 1 == distance.get(curr)) {
                                dfs(graph, distance, nextWord, end, results, path);
                                //path.remove(path.size() - 1);
                            }
                    }
                    path.remove(path.size() - 1);
                }
    
    //bfs 同时更新graph和distance 
    private void bfs(Map<String, List<String>> graph, Map<String, Integer> distance, 
                String start, String end, Set<String> dict) {
                    Queue<String> queue = new LinkedList<>();
                    queue.offer(start);
                    distance.put(start, 0);
                    for (String word : dict) {
                        graph.put(word, new ArrayList<String>());
                    }
        
                    while (!queue.isEmpty()) {
                        String curr = queue.poll();
                
                        for (String nextWord : getNextWords(dict, curr)) {
                            // if (!graph.containsKey(curr)) {
                            //     graph.put(curr, new ArrayList<String>());
                            // }
                            graph.get(curr).add(nextWord);
                            
                            if (!distance.containsKey(nextWord)) {
                                distance.put(nextWord, distance.get(curr) + 1);
                                queue.offer(nextWord);
                            }
                        }
                    }
                }
                
    private List<String> getNextWords(Set<String> dict, String curr) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) == c) {
                    continue;
                }
                //String nextWord = curr.substring(0, i) + c + curr.substring(i + 1);
                String nextWord = replace(curr, i, c);
                if(dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        
        return nextWords;
    }
    
    private String replace (String word, int index, char c) {
        char[] ch = word.toCharArray();
        ch[index] = c;
        return String.valueOf(ch);
    }
}
