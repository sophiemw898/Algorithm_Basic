class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if (Math.abs(m - n) > 1) {
            return false;
        }
        // Ensure that s is shorter than t.
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        
        return m + 1 == n;
    }
}
