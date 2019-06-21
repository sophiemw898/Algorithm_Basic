class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        if(n == 0) {
            return 0;
        }
        
        for (int i = 0; i <= m - n; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            if (needle.equals(haystack.substring(i, i + n))) {
                return i;
            }
        }
        
        return -1;
    }
}
