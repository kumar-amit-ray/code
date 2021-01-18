/**
  Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

@Leetcode - https://leetcode.com/problems/subarray-sum-equals-k/
@youtube - https://www.youtube.com/watch?v=AmlVSNBHzJg
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        
        // we have seen sum 0 once.
        hmap.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            // if we see sum-k, then sum between this two point is equal to k. 
            if (hmap.containsKey(sum - k)) {
                result += hmap.get(sum - k);
            }
            // If we have seen this sum before, incremenet the count, else initialize as 1
            hmap.put(sum, hmap.getOrDefault(sum, 0)+1);
            
        }
        return result;
    }
}
