class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !isValid(s.charAt(i))) {
                i++;
            }
            while (i < j && !isValid(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(Character c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
