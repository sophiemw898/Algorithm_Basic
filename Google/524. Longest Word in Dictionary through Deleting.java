class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (String word : d) {
            if (isSeq(s, word)) {
                if (word.length() > res.length() || 
                    //((word.length()== res.length()) && word.compareTo(res) < 0)) {
                    ((word.length()== res.length()) && isSmaller(word, res))) {
                    res = word;
                }
            }
        }
        
        return res;
    }
    
    private boolean isSmaller(String word, String res) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == res.charAt(i)) {
                continue;
            } else if (word.charAt(i) < res.charAt(i)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    private boolean isSeq(String s, String d) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < d.length() && c == d.charAt(i)) {
                i++;
            }
        }
        
        return i == d.length();
    }
}
