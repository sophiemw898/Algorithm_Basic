class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        
        int[] intersection = new int[res.size()];
        int index = 0;
        for (int num : res) {
            intersection[index++] = num;
        }
        
        return intersection;
    }
}
