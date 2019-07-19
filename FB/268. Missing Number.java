//O(n) O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            while (nums[i] != i && nums[i] < n) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            i++;
        }
        
        for (int j = 0; j < n; j++) {
            if (nums[j] != j) {
                //System.out.println(j);
                return j;
            }
        }
        
        return n;
    }
}
//#1 O(n) O(n)
class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }
}

//O(nlogn) O(1)
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
}
