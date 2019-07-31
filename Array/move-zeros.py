'''
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

'''
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if nums is None or len(nums)==0: return
        i = 0
        j = 0
        while i<len(nums):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j +=1
            
            i +=1
                
            
