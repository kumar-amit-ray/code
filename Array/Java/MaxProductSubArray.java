/**
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
@Leetcode - https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}
        int max_prod = nums[0];
        int min_prod = nums[0];
        int prev_max_prod = nums[0];
        int prev_min_prod = nums[0];
        int result = max_prod;
        
        for (int i = 1; i<nums.length; i++) {
            max_prod = Math.max(nums[i], Math.max(prev_max_prod * nums[i], prev_min_prod * nums[i]));
            min_prod = Math.min(nums[i], Math.min(prev_max_prod * nums[i], prev_min_prod * nums[i]));
                                            
            result = Math.max(result, max_prod);
            
            prev_max_prod = max_prod;
            prev_min_prod = min_prod;
        }
        return result;
    }
}
