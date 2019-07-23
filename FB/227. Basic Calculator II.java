class Solution {
    public int calculate(String s) {
        int res = 0;
        int prev = 0;
        
        int index = 0;
        char sign = '+';
        while (index < s.length()) {

            if (s.charAt(index) == ' ') {
                index++;
                continue;
            }
            int num = 0;
            while(index < s.length() && Character.isDigit(s.charAt(index))) {
                num = 10 * num + s.charAt(index) - '0';
                index++;
            }
        
            if (sign == '+') {
                res += prev;
                prev = num;
            } else if (sign == '-') {
                res += prev;
                prev = -num;
            } else if (sign == '*') {
                prev = prev * num;
            } else if (sign == '/') {
                prev = prev / num;
            } 
          
            if (index < s.length()) {
                sign = s.charAt(index);
            }
            
            index++;
        }
        
        res += prev;
        return res;
    }
}
