/*
Find maximum height of bar from the left end upto an index i in the array left_max.
Find maximum height of bar from the right end upto an index i in the array right_max.
Iterate over the height array and update ans:
Add min(max_left[i],max_right[i])−height[i] to ansans
*/

//two pointers
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        
        int left_max = 0;
        int right_max = 0;
       
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    res += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    res += right_max - height[right];
                }
                right--;
            }
        }
        
        return res;
    }
}

/*
Find maximum height of bar from the left end upto an index i in the array left_max.
Find maximum height of bar from the right end upto an index i in the array right_max.
Iterate over the height array and update ans:
Add min(max_left[i],max_right[i])−height[i] to ansans
*/

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
            //System.out.println(left[i]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i + 1], right[i + 1]);
        }
        
        //traver again to add res
        for (int i = 0; i < n; i++) {
            if (Math.min(left[i], right[i]) - height[i] > 0) {
                res += Math.min(left[i], right[i]) - height[i];
            };
        }
        
        return res;
    }
}

