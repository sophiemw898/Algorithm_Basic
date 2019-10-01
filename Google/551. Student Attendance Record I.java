class Solution {
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i= 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                count++;
                if (count > 1) {
                    return false;
                }
            } else if (c == 'L' && i < s.length() - 2 && s.substring(i, i + 3).equals("LLL")) {
                return false;
            }                
        }
        
        return true;
    }
}
