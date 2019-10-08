//dfs
class Solution {
    
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, 0, new boolean[bikes.length], 0);
        return min;
    }
    
    private void dfs(int[][] workers, int[][] bikes, int index, boolean[] used, int sum) {
        if (index == workers.length) {
            min = Math.min(min, sum);
            return;
        }
        
        if (min < sum) {
            return;
        }
        
        for (int i = 0; i < bikes.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            dfs(workers, bikes, index + 1, used, sum + calc(workers[index], bikes[i]));
            used[i] = false;
        }
    }
    
    private int calc(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
