//O(n^2)

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        } else if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        } 
        
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                break;
            } 
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}

//Easier coding
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}
