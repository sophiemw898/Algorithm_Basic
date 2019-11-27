class Solution {
    /**
     * Follow-up
     * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t.
     * This is inefficient.
     * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t.
     * Sounds like a HashMap, which is super suitable for search for existing stuff.
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        
        //use a map to save each letter and its position in t, then we don't need to serach t
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), new ArrayList<>());
            }
            map.get(t.charAt(i)).add(i);
        }
        //use prev to save the last letter's position in t
        //binary search map to find the first position Prev for curr letter
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            List<Integer> lists = map.get(c);
            prev = findNextPos(lists, prev);
            if (prev == -1) {
                return false;
            }
        }
        
        return true;
    }
    //find the first position > index
    private int findNextPos(List<Integer> lists, int index) {
        int start = 0, end = lists.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (lists.get(mid) > index) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (lists.get(start) > index) {
            return lists.get(start);
        }
        if (lists.get(end) > index) {
            return lists.get(end);
        }
        return -1;
    }
}

//O(T)
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int index = 0;
        for (int i = 0; i < t.length(); i++) {

            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        
        return false;
    }
}
