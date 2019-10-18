class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            if(check(S, word)) {
                res++;
            }
        }
        
        return res;
    }
    
    private boolean check(String S, String word) {
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            if (j < word.length() && S.charAt(i) == word.charAt(j)) {
                j++;
            } else if (i > 0 && i < S.length() - 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i) == S.charAt(i + 1)) {//重复位置的第二个
                continue;
            } else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i) == S.charAt(i - 2)) {//重复位置的第三个及以后
                continue;
            } else {
                return false;
            }
        }
        
        return j == word.length();
    }
}

class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            if(check(S, word)) {
                res++;
            }
        }
        
        return res;
    }
    
    private boolean check(String S, String word) {
        int i = 0; 
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) != word.charAt(j)) {
                return false;
            }
            int oldI = i;
            int oldJ = j;
            while (i < S.length() && S.charAt(i) == S.charAt(oldI)) {
                i++;
            }
            while (j < word.length() && word.charAt(j) == word.charAt(oldJ)) {
                j++;
            }
            
            int lenS = i - oldI;
            int lenWord = j - oldJ;
            if (lenS != lenWord && (lenS < lenWord || lenS < 3)) {
                return false;
            }
        }
        
        //System.out.println(word);
        return (i == S.length()) && (j == word.length());
    }
}
