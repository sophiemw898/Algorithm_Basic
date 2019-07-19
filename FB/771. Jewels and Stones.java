class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        
        int count = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
