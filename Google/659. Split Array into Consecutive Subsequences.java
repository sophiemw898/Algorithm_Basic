/*
to summarize, the map variable "appendfreq", stands for the "qualification" of current number, to be appended to the previous sequence.
        
Took me a while to understand "appendfreq"
Here is how I see "appendfreq"

eg: [1,2,3,4, 5]
// i =1
we fall in 3 case "start of a new subsequence"
we make 2, 3 freq 0
and put <4, 1> in appendfreq, this mean I have 1 subsequence can continue from 4

//i =2, 3
we continue

//i = 4
we fall in 2 case since <4, 1> is in appendfreq
now this subsequence should end in 5
so we decreace <4, 1> to <4, 0> since we no longer have subsequence can continue from 4
and we put <5, 1> in appendfreq since now we have a subsequence can continue from 5

*/
class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> validForAppend = new HashMap<>();
        
        //save the frequence of each num
        for (int num : nums) {
        //     if (!count.containsKey(num)) {
        //         count.put(num, 0);
        //     }
        //     count.put(num, count.get(num) + 1);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if (count.get(num) == 0) {
                continue;
            } else if (validForAppend.getOrDefault(num, 0) > 0) {
                //check if it can be appended
                validForAppend.put(num, validForAppend.get(num) - 1);
                validForAppend.put(num + 1, validForAppend.getOrDefault(num + 1, 0) + 1);
            } else if (count.getOrDefault(num + 1, 0) > 0 
                      && count.getOrDefault(num + 2, 0) > 0) {
                count.put(num + 1, count.get(num + 1) - 1);
                count.put(num + 2, count.get(num + 2) - 1);
                validForAppend.put(num + 3, validForAppend.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            count.put(num, count.get(num) - 1);
        }
        
        return true;
    }
}
