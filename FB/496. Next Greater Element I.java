//O(m + n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        //map is used to store the result for every posssible number in nums in the form of (element,next_greater_element)
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

//Brute Force O(mn)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            int j = 0;
            for (; j < nums2.length; j++) {
                if (found && nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
                if (nums1[i] == nums2[j]) {
                    found = true;
                }
            }
            if (j == nums2.length) {
                res[i] = -1;
            }
        }
        return res;
    }
}
