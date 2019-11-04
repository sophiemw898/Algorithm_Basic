class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
    
        int i = m - 1;
        int j = 0;
        //for each point, if the num is larger then target, go up, 
        //if the num is small then target, go right
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        
        return false;
    }
}
//O(n + m)
