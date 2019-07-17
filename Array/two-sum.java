/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
Git statusreturn [0, 1].
*/



class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        
        Map <Integer,Integer> map = new HashMap<>();
        
        for (int i=0; i <nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}

In Python
=========
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        result = list()
        hashmap = dict()

        if nums is None or len(nums) == 0:
            return result
        i=0
        for index, num in enumerate(nums):
            if (target-num) in hashmap:
                result.append(hashmap[target - num])
                result.append(index)
                break
                
            if num not in hashmap:
                hashmap[num] = index
            i +=1

        return result
