// S = "abcde"
// words = ["a", "bb", "acd", "ace"]
// Output: 3
//Runtime is linear in the total size of the input (S and all of words).

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        
        Map<Character, Queue<String>> waiting = new HashMap<>();
        
        for (char i = 'a'; i <= 'z'; i++) {
            waiting.put(i, new LinkedList<>());
        }
        for (String word : words) {
            waiting.get(word.charAt(0)).offer(word);
        }
        
        for (char c : S.toCharArray()) {
            if (waiting.get(c).size() == 0) {
                continue;
            }
            int size = waiting.get(c).size();
            
            for (int i = 0; i < size; i++) {
                String word = waiting.get(c).poll();
                if (word.length() == 1) {
                    count++;
                } else {
                    waiting.get(word.charAt(1)).offer(word.substring(1));
                }
            }
        }
        
        return count;
    }
}
