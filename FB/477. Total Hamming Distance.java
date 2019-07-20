//For each bit position 1-32 in a 32-bit integer, we count the number of integers in the array which have that bit set. Then, if there are n integers in the array and k of them have a particular bit set and (n-k) do not, then that bit contributes k*(n-k) hamming distance to the total.
class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int total = 0;
        
        for (int i = 0; i < 32; i++) {
            int countOne = 0;
            for (int j = 0; j < n; j++) {
                //注释掉的是错误的，每次右移一位不能控制停的位置
                //nums[j] = nums[j] >> 1;
                //countOne += nums[j] & 1;
                countOne += (nums[j] >> i) & 1;
            }
            
            total += countOne * (n - countOne);
        }
        
        return total;
    }
}
