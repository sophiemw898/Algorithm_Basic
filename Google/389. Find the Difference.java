//faster O(1) space
class Solution {
    public char findTheDifference(String s, String t) {
        //Map<Character, Integer> count = new HashMap<>();
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return c;
            }
            count[c - 'a']--;
        }
        
        return 'A';
    }
}

//hashmap O(n) space
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (!count.containsKey(c)) {
                count.put(c, 0);
            }
            count.put(c, count.get(c) + 1);
        }
        
        for (char c : t.toCharArray()) {
            if (!count.containsKey(c) || count.get(c) == 0) {
                return c;
            }
            count.put(c, count.get(c) - 1);
        }
        
        return 'A';
    }
}
