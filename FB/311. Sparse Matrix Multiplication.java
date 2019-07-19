//排除A[][]= 0 和 b[][] = 0再计算。觉得没太必要，容易出错且增加了空间复杂度
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int k = B[0].length;
        //记录B中每一列里对应的 值为0 的行系数
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < k; j++) {
                if (B[i][j] != 0) {
                    map.get(i).add(j);
                }
            }
        }
        
        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < m; p++) {
                if (A[i][p] == 0) {
                    continue;
                }
                    for (int j : map.get(p)) {
                    C[i][j] += A[i][p] * B[p][j]; 
                }
            }
        }
        
        return C;
    }
}

//先排除A[][] = 0 再计算
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int k = B[0].length;

        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < m; p++) {
                if (A[i][p] == 0) {
                    continue;
                }
                for (int j = 0; j < k; j++) {
                    C[i][j] += A[i][p] * B[p][j]; 
                }
            }
        }
        
        return C;
    }
}
//最慢
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int k = B[0].length;

        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int p = 0; p < m; p++) {
                    C[i][j] += A[i][p] * B[p][j]; 
                }
            }
        }
        
        return C;
    }
}

