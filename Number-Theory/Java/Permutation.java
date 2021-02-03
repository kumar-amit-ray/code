/**
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

@Leetcode - https://leetcode.com/problems/permutations/
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numSet = new ArrayList<>();

        for (int num : nums) {
            numSet.add(num);
        }

        permuteRecursive(numSet, new ArrayList<Integer>(), result);
        return result;
    }
    
    private List<Integer> getListExcludeCurrent(List<Integer>nums, int index) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.size(); i++) {
            if (i != index) {
                result.add(nums.get(i));
            }
        }
        return result;
    }

    private void permuteRecursive(List<Integer> nums, List<Integer> running, List<List<Integer>> result) {
        if (nums.size() == 0) {
            // if we have no element in the list, we got a result. Copy it
            result.add(new ArrayList<>(running));
        } else {
            for (int i=0; i<nums.size(); i++) {
                // Copy all element of the list except the current one. 
                List<Integer> newNums = getListExcludeCurrent(nums, i);
                // add current element to the list
                running.add(nums.get(i));
                // recurse on the new list
                permuteRecursive(newNums, running, result);
                // remove current element from the list
                running.remove(nums.get(i));
            }
        }
    }
}
