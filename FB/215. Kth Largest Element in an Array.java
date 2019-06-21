//O(nlogn) O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }
        
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

//O(N lg K) running time + O(K) memory
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }
        
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int num : nums) {
            heap.offer(num);
        }
        
        while (heap.size() > k) {
            heap.poll();
        }
        
        return heap.poll();
    }
}
