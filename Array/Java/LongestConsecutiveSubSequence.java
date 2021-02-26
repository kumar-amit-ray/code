/**
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
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i]-1)) {
                continue;
            } else {
                int length = 0;
                int start = nums[i];
                while (set.contains(start)) {
                    start++;
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
