/**
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

@Leetcode - https://leetcode.com/problems/subsets/
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Add first number to the result as standalone set
        result.add(Arrays.asList(nums[0]));
        for (int i=1; i<nums.length; i++) {
            // Copy all the existing sets
            List<List<Integer>> newResult = new ArrayList<>(result);
            for (List<Integer> eachSet: result) {
                // Add nums[i] to all the sets
                List<Integer> newSet = new ArrayList<>(eachSet);
                newSet.add(nums[i]);
                newResult.add(newSet);
            }
            // Add nums[i] as standalone set 
            newResult.add(Arrays.asList(nums[i]));
            result = newResult;
        }
        // Add an Empty set
        result.add(new ArrayList<Integer>());
        return result;
    }
}
