class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; 
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            
            //数字不能以0开头
            if (!Character.isDigit(abbr.charAt(j)) || abbr.charAt(j) == '0') {
                return false;
            }
            
            //get the num
            int num = 0;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                num = 10 * num + abbr.charAt(j) - '0';
                j++;
            }
            i += num;
        }
        
        return i == word.length() && j == abbr.length();
    }
}
