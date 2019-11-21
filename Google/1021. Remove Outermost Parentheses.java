//count 
class Solution {
    public String removeOuterParentheses(String S) {
        String ans = "";
        if (S == null || S.length() == 0) {
            return ans;
        }
        
        int start = 0;
        int open = 0, close = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            
            if (open == close) {
                ans += S.substring(start + 1, i);
                start = i + 1;
            }
        }
        
        return ans;
    }
}

//stack
class Solution {
    public String removeOuterParentheses(String S) {
        String ans = "";
        if (S == null || S.length() == 0) {
            return ans;
        }
        
        //find the primitive one by one
        Stack<Character> stack = new Stack<>();
        String curr = "";
        int i = 0;
        
        while (i < S.length()) {
            char c = S.charAt(i);
            curr += c;
            
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                //remove the outermost parentheses
                ans += curr.substring(1, curr.length() - 1);
                curr = "";
            }
            
            i++;
        }
        
        return ans;
    }
}
