/*
1 1 1 1 1
1 0 0 0 1
1 0 1 0 1
1 0 0 0 1
1 1 1 1 1
*/
//找到第一个1，dfs一圈将所有与之相连的都变成2 O(N)
//找第一个2,计算2到1的最短路径，不断更新最小值
//计算过程用个map 记录走过的点到1的距离
class Solution {
    
    Queue<int[]> queue = new LinkedList<>();
    int[] dirs = new int[] {0,1,0,-1,0};
    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = 0;
        
        //找到第一个1，dfs一圈将所有与之相连的都变成2 O(N)
        boolean found = false;
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    transform(A, i, j);
                    found = true;
                    break;
                }
            }
        }
        
        //System.out.println(queue.size());
        //use bfs to find the shorest path from all 2 to all 1
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                
                // System.out.println(point[0]);
                // System.out.println(point[1]);
                for (int index = 0; index < 4; index++) {
                    int row = point[0] + dirs[index];
                    int col = point[1] + dirs[index + 1];
                    if (row >= 0 && row < A.length && col >= 0 && col < A[0].length && A[row][col] != 3) {
                        if (A[row][col] == 1) {
                            return res;
                        }
                        queue.offer(new int[] {row, col});
                        A[row][col] = 3;    
                    }
                }
            }
            res++;
        }
        
        return res;
    }
    
    private void transform(int[][] A, int i, int j) {
        A[i][j] = 2;
        queue.offer(new int[] {i, j});
    
        for (int index = 0; index < 4; index++) {
            int row = i + dirs[index];
            int col = j + dirs[index + 1];
            if (row >= 0 && row < A.length && col >= 0 && col < A[0].length && A[row][col] == 1) {
                transform(A, row, col);
            }
        }
    }
}
