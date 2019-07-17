/*
Given an array of n positive integers and a positive integer s, find the maximum 
length of a contiguous subarray of which the sum=k.
Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Ouptut: Sum found between indexes 0 to 3

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Ouptut: No subarray with given sum exists
*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum=0;
        int maxLen=0;

        Map <Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum-k)) {
                maxLen = Math.max(maxLen, i - map.get(sum-k));
            }
        }
        return maxLen;
    }
}

In Python
---------
'''
 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Leetcode - https://leetcode.com/problems/subarray-sum-equals-k/
'''
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        map = dict()
        count=0
        sum = 0
        map[sum] = 1
        for num in nums:
            sum +=num
            if sum-k in map:
                count += map[sum-k]
            if sum in map:
                map[sum] +=1
            else:
                map[sum] = 1
        
        return count
