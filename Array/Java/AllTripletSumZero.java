/**
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []

@Leetcode - https://leetcode.com/problems/3sum/
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        
        if (nums == null || nums.length < 3) {
            return new ArrayList(result);
        }
        
        for (int i = 0; i<nums.length; i++) {
            Map<Integer, Integer> hmap = new HashMap();
            for (int j = i + 1; j<nums.length; j++) {
                int complement = 0 - nums[i] - nums[j];
                if (hmap.containsKey(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
                // put the number after we build the triplet so that complement is not one of complement != nums[j]
                hmap.put(nums[j], j);
            }
            
        }
        return new ArrayList(result);
    }
    
    private Map<Integer, Integer> populateHashMap(int[] nums, int start) {
        Map<Integer, Integer> hmap = new HashMap();
        
        for (int i=start; i<nums.length; i++) {
            hmap.put(nums[i], i);
        }
        
        return hmap;
    }
}
