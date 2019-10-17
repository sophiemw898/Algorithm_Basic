//O(n^2) worst
class Solution {
    public int removeStones(int[][] stones) {
        //res = # of stones - # of islands
        if (stones == null || stones.length <= 1) {
            return 0;
        }
        
        int numOfIsland = 0;
        boolean[] visited = new boolean[stones.length];
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                helper(i, visited, stones);
                numOfIsland++;
            }
        }
        
        return stones.length - numOfIsland;
    }
    
    private void helper(int pos, boolean[] visited, int[][] stones) {
        visited[pos] = true;
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && 
                (stones[i][0] == stones[pos][0] || stones[i][1] == stones[pos][1])) {
                helper(i, visited, stones);
            }
        }
    }
}
