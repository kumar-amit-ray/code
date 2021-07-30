'''

	6. Find a sorted subsequence of size 3 in linear time
Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. If there are multiple such triplets, 
then print any one of them.
Examples:
Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30
Input:  arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4
Input:  arr[] = {4, 3, 2, 1}
Output: No such triplet
'''

class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) < 3: return False
        
        first = nums[0]
        second = float('inf')
        
        for num in nums:
            if num > second: return True
            elif second > num > first: second = num
            elif num < first: first = num
        
        return False
                
