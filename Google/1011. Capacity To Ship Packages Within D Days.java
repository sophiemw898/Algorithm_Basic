class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int maxWeight = 0;
        int sumWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            sumWeight += weight;
        }
        
        int left = maxWeight, right = sumWeight;
        //find least weight capacity to meet the condition
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (isEnough(mid, weights, D)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return isEnough(left, weights, D) ? left : right;
    }
    
    private boolean isEnough(int pos, int[] weights, int D) {
        int count = 1;
        int curr = 0;
        for (int weight : weights) {
            if (curr + weight > pos) {
                count++;
                curr = 0;
            }
            curr += weight;
        }
        
        return count <= D;
    }
}
