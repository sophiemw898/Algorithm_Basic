//O(n) O(1)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int countS = 0;
        int countT = 0;
        
        while (i >= 0 || j >= 0) {
            
            //Find position of next possible char in build(S)
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    countS++;
                    i--;
                } else if (countS > 0) {
                    countS--;
                    i--;
                } else {
                    break;
                }
            }
            //Find position of next possible char in build(T)
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    countT++;
                    j--;
                } else if (countT > 0) {
                    countT--;
                    j--;
                } else {
                    break;
                }
            }
            
//              System.out.println(i);
//              System.out.println(j);
            
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
}

//O(n) o(n)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                stackS.push(c);
            } else if (c == '#' && !stackS.empty()) {
                stackS.pop();
            }
        }
        
        Stack<Character> stackT = new Stack();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (Character.isLetter(c)) {
                stackT.push(c);
            } else if (c == '#' && !stackT.empty()) {
                stackT.pop();
            }
        }
        
        // while (!stackS.empty() && !stackT.empty()) {
        //     if (stackS.pop() != stackT.pop()) {
        //         return false;
        //     }
        // }
        
        //return stackS.empty() && stackT.empty();
        return String.valueOf(stackS).equals(String.valueOf(stackT));
    }
}
