/*1  2  3  4
12 13 14 5
11 16 15 6
10 9  8  7
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int num = 1;
        int minI = 0, maxI = n - 1, minJ = 0, maxJ = n - 1;
        
        while (num <= n * n) {
            for (int j = minJ; j <= maxJ; j++) {
                res[minI][j] = num++;
            }
            minI++;
            for (int i = minI; i <= maxI; i++) {
                res[i][maxJ] = num++;
            }
            maxJ--;
            for (int j = maxJ; j >= minJ; j--) {
                res[maxI][j] = num++;
            }
            maxI--;
            for (int i = maxI; i >= minI; i--) {
                res[i][minJ] = num++;
            }
            minJ++;
        }
        
        return res;
    }
}

//adapt to rectangle m * n
public class Solution {
    public int[][] generateMatrix(int n) {
        // Declaration
        int[][] matrix = new int[n][n];
        
        // Edge Case
        if (n == 0) {
            return matrix;
        }
        
        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; //change
            }
            rowStart ++;
            
            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++; //change
            }
            colEnd --;
            
            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; //change
            }
            rowEnd --;
            
            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++; //change
            }
            colStart ++;
        }
        
        return matrix;
    }
}

