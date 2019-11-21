class Solution {
    public String longestWord(String[] words) {
        Set<String> dict = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        
        String ans = "";
        boolean isValid = true;
        Set<String> set = new HashSet<>();

        for (String word : words) {
            //check all valid subStr for word
            if (ans.length() < word.length() || 
                    (ans.length() == word.length() && word.compareTo(ans) < 0)) {
                isValid = true;
                for (int i = word.length() - 1; i > 0; i--) {
                    String subStr = word.substring(0, i);
                    if (set.contains(subStr)) {
                        set.add(word);
                        continue;
                    }
                    if (!dict.contains(subStr)) {
                        isValid = false;
                        break;
                    }
                }
                
                if (isValid) {
                    ans = word;
                }
            }
        }
        
        return ans;
    }
}
