//最优O(n)O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[index] = nums1[m - 1];
                index--;
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                index--;
                n--;
            }
        }
        
        //System.out.println(m);
        //System.out.println(n);
        //System.out.println(index);
        
        //if m > 0, nums1 is longer, just keep it. no need to copy
        //if n > 0, nums2 is longer, need to copy missing elements in nums2
        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
        return;
    }
}
