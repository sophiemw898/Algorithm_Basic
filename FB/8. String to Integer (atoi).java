class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i >= str.length()) {
            return 0;
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-' && !Character.isDigit(str.charAt(i))) {
            return 0;
        }
        
        int sign = 1;
        if (str.charAt(i) == '+') {
            i++;
        }  else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
            
        int res = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
            }
            res = 10 * res + str.charAt(i++) - '0';
        }
               
        return sign * res;
    }
}

