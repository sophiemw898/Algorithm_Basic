/*
Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. 
Return the number of pairs.

Example 1:
Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47

Example 2:
Input: nums = [1, 1], target = 2
Output: 1
Explanation:
1 + 1 = 2

Example 3:
Input: nums = [1, 5, 1, 5], target = 6
Output: 1
Explanation:
[1, 5] and [5, 1] are considered the same.
*/

package com.example.idea;

import java.util.HashSet;
import java.util.Set;

public class TwoSumAmazon {
    public int twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int count = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> isExist = new HashSet<>();

        for (int num : nums) {
            if (set.contains(target - num)) {
                if (!isExist.contains(num)) {
                    count++;
                    //System.out.println(count);
                    isExist.add(num);
                    isExist.add(target - num);
                }
            } else {
                set.add(num);
            }
        }

        return count;
    }
}
