//bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        
        //wordList.add(beginWord);
        //wordList.add(endWord);
        Set<String> words = new HashSet<>();
        for (String str : wordList) {
            words.add(str);
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        queue.offer(beginWord);
        set.add(beginWord);
        
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String next : getNextWord(words, word)) {
                    if (next.equals(endWord)) {
                        return step;
                    }
                    if (!set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getNextWord(Set<String> words, String word) {
        List<String> res = new ArrayList<>();
        
        //每次都构造 会超时
        // Set<String> words = new HashSet<>();
        // for (String str : wordList) {
        //     words.add(str);
        // }
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == c) {
                    continue;
                }
                String next = replace(word, i, ch);
                if (words.contains(next)) {
                    res.add(next);
                }
            }
        }
        
        return res;
    }
    
    private String replace (String word, int index, char c) {
//         StringBuilder sb = new StringBuilder();
//         sb.append(word.substring(0, index));
//         sb.append(c);
//         if (index < word.length()) {
//             sb.append(word.substring(index + 1));
//         }
        
//         return sb.toString();
        char[] ch = word.toCharArray();
        ch[index] = c;
        return String.valueOf(ch);
    }
}
