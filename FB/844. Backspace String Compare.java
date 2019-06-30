//two pointers O(m + n) O(1)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1; 
        int j = T.length() - 1;
        int deleteS = 0;
        int deleteT = 0;
        
        while (i >= 0 || j >= 0) {
            //Find position of next possible char in build(S)
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    deleteS++;
                    i--;
                } else if (deleteS > 0) {
                    i--;
                    deleteS--;
                } else {
                    break;
                }
            }
            //Find position of next possible char in build(T)
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    deleteT++;
                    j--;
                } else if (deleteT > 0) {
                    j--;
                    deleteT--;
                } else {
                    break;
                }
            }
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

//stack O(m + n) O(m + n)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        //null length == 0
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stackS.push(S.charAt(i));
            } else if (!stackS.empty()) {
                stackS.pop();
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                stackT.push(T.charAt(i));
            } else if (!stackT.empty()) {
                stackT.pop();
            }
        }
        
        while (!stackS.empty() && !stackT.empty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        
        return stackS.empty() && stackT.empty();
    }
}
