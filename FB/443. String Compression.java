//solution
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            char cur = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == cur) {
                count++;
                i++;
            }
            chars[index++] = cur;
            //count == 100
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        
        return index;
    }
}
//1st
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        int index = 1;
        int i = 1;
        while (i < chars.length) {
            int count = 1;
            while (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
                i++;
            }
            //count == 100
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
            
            if (i == chars.length) {
                return index;
            }
            
            chars[index++] = chars[i++];
        }
        
        return index;
    }
}

