//Time Complexity: O(NlogN). For each X, we check each digit.
//Space Complexity: O(logN), the space stored either by the string, or the recursive call stack of the function good.

class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (check(i, false)) {
                res++;
            }
        }
        return res;
    }
    
    private boolean check(int n, boolean flag) {
        //dfs 出口
        if (n == 0) {
            return flag;
        }
        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) {
            return false;
        }
        if (d == 0 || d == 1 || d == 8) {
            return check(n/10, flag);
        }
        return check(n/10, true);
    }
}
