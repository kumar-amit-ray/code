/**
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2 
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
Follow Up:
Can you do it in O(n) time?

@Leetcode - https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
@Youtube - https://www.youtube.com/watch?v=ReZpa5vxRKc
*/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int sum = 0;
        int result = 0;
        
        /**
         assume we have seen sum 0 and at index -1.
         E.g. nums: [3,1] k=4.
         */
        hmap.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
             
            if (hmap.containsKey(sum - k)) {
                result = Math.max(result, i - hmap.get(sum - k));
            }
            // note that we always want the longest subarray length. Hence if sum already exist
            // we don't update it. 
            if (!hmap.containsKey(sum)) {
                hmap.put(sum, i);
            }
        }
        return result;
    }
}
