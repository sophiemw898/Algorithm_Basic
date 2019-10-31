//O(N) O(1)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int prev = -1;
        
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                res = prev < 0 ? i : Math.max(res, (i - prev) / 2);
                prev = i;
            }
        }
        
        //check if the last seat is empty
        res = Math.max(res, seats.length - 1 - prev);
        
        return res;
    }
}

//O(N) O(N)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, n);
        Arrays.fill(right, n);
        
        left[0] = seats[0] == 1 ? 0 : n;
        for (int i = 1; i < n; i++) {
            if (seats[i] == 1) {
                left[i] = 0;
            } else {
                left[i] = left[i - 1] + 1;
            }
        }
        right[n - 1] = seats[n - 1] == 1 ? 0 : n;
        for (int i = n - 2; i >= 0; i--) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else {
                right[i] = right[i + 1] + 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.min(left[i], right[i]));
        }
        
        return res;
    }
}
