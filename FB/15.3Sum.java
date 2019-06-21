//O(n*n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        //sort the array O(nlogn)
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            //find 2-sum equals to -nums[i]
            //skip all same number for 1st
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == -nums[i]) {
                        res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        // List<Integer> temp = new ArrayList<>();
                        // temp.add(nums[i]);
                        // temp.add(nums[left]);
                        // temp.add(nums[right]);
                        // res.add(temp);
                        //delete all same number for 2nd and 3rd
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }    
        }
        return res;
    }
}
