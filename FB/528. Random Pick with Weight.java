class Solution {
//记录preSum
//get random int from 0 sum
//Use binary search to find index x，x is the lowest index such that target<p[x]
    List<Integer> preSum;
    int sum = 0;
    
    public Solution(int[] w) {
        preSum = new ArrayList<>();
        for (int num : w) {
            sum += num;
            preSum.add(sum);
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int target = rand.nextInt(sum);
        
        int start = 0; 
        int end = preSum.size() - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (preSum.get(mid) > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return preSum.get(start) > target ? start : end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
