//Divide and conquer - quickSort 
//aveO(N) 
//spaceO(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        
        int i = start; 
        int j = end;
        int pivot= nums[(i + j)/2];
        
        //to get kth largest, sort array from big to small
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        //start - j - pivot - i - end
        //the kth on left side j - start + 1 >= k
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        //the kth on right side i - start + 1 <= k
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        
        //the kth between j and i
        return nums[j + 1];
    }
}

//priorityQueue
//O(NlogK)
//O(K)
class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
         for (int num : nums) {
             pq.offer(num);
             
             if (pq.size() > k) {
                 pq.poll();
             }
         }
        
        return pq.peek();
    }
}
