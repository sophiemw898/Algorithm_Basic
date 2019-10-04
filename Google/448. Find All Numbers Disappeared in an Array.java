class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //sort O(NlogN)
        //Set O(N) with extra space
        
        //O(N) no extras space 
        //The idea is simple, if nums[i] != i + 1 and nums[i] != nums[nums[i] - 1], then we swap nums[i] with nums[nums[i] - 1], for example, nums[0] = 4 and nums[3] = 7, then we swap nums[0] with nums[3]. So In the end the array will be sorted and if nums[i] != i + 1, then i + 1 is missing.
        // The example run as follows

        // [4,3,2,7,8,2,3,1]
        // [7,3,2,4,8,2,3,1]
        // [3,3,2,4,8,2,7,1]
        // [2,3,3,4,8,2,7,1]
        // [3,2,3,4,8,2,7,1]
        // [3,2,3,4,1,2,7,8]
        // [1,2,3,4,3,2,7,8]
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                //swap
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //sort O(NlogN)
        //Set O(N) with extra space
        
        //O(N) no extras space 
        //make the index with neg
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}
