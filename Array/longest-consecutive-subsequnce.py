/*
Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence
are consecutive integers, the consecutive numbers can be in any order.
Examples

Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence
of consecutive elements

Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
The subsequence 36, 35, 33, 34, 32 is the longest subsequence
of consecutive elements.

Link to the solution - https://www.geeksforgeeks.org/longest-consecutive-subsequence/
*/

class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums)==0: return 0
        hmap = dict()
        result = 0
        for index, num in enumerate(nums):
            hmap[num] = index
        
        for num in nums:
            if num-1 in hmap:
                continue
            else:
                temp = num
                while temp in hmap:
                    temp +=1
                
                result = max(result, temp-num)
        
        return result
