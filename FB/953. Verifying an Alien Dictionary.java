class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //use index[] to record the position of different letters
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        //compare each word with next word
        for (int i = 0; i < words.length - 1; i++) {
            //words[i] words[i + 1]
            int length = Math.min(words[i].length(), words[i + 1].length());
            // Find the first difference word1[k] != word2[k].
            int j;
            for (j = 0; j < length; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                     if (index[words[i].charAt(j) - 'a'] > index[words[i + 1].charAt(j) - 'a']) {
                         return false;
                     } else {
                         break;
                     }
                }
            }
            if (j == length && words[i].length() > words[i + 1].length()) {
                return false;
            }
        }
        
        return true;
    }
}
