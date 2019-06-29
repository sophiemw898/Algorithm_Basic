class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.get(c) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}

//用数组可将空间复杂度由O(N)降到O(1) int [] charCount = new int[26];
