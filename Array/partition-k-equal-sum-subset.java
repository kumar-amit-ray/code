/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Solution Description - https://leetcode.com/problems/partition-to-k-equal-sum-subsets/solution/
*/

class Solution {
    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }
}


In Python
=========
class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if nums is None or len(nums)==0:
            return False
        if k==0:
            return True
        if sum(nums)%k != 0:
            return False
        target = sum(nums)/k

        row = len(nums)-1
        while row >=0 and nums[row] == target:
            row -=1
            k -=1

        groups = [0]*k
        return self.canPartitionKSubsets_recursive(groups, row, k, nums, target)

    def canPartitionKSubsets_recursive(self, groups, row, k, nums, target):
        if row <0:
            return True
        
        nums.sort()
        v = nums[row]
        row -=1
        i=0
        while i<len(groups):
            if groups[i]+v <=target:
                groups[i] +=v
                if self.canPartitionKSubsets_recursive(groups, row, k, nums, target):
                    return True
                groups[i] -=v
            if groups[i] == 0:
                break;
            i +=1

        return False
