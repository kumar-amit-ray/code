package ArraySearch;

public class RotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new RotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    /**
     * You are given an integer array nums sorted in ascending order, and an integer target.
     *
     * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * If target is found in the array return its index, otherwise, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     * @Leetcode - https://leetcode.com/problems/search-in-rotated-sorted-array/
     */

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return -1;}

        int pivot = findPivot(nums);
        if (target >=nums[pivot] && target <= nums[nums.length-1]) {
            return binarySearch(nums, pivot, nums.length-1, target);
        } else {
            return binarySearch(nums, 0, pivot, target);
        }
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left +(right - left)/2;
            if (target == nums[mid]) {return mid;}
            if (target > nums[mid]) {left = mid+1;}
            else {right = mid-1;}
        }
        return -1;
    }

    /**
     *
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * Follow up: Could you write an algorithm with O(log n) runtime complexity?
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     *
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     *
     * @Leetcode - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        searchRangeRecursive(nums, target, result, 0, nums.length-1);
        return result;
    }

    private void searchRangeRecursive(int[] nums, int target, int[] result, int left, int right) {
        // protection check
        if (left > right) {return;}

        int mid = left + (right - left)/2;
        if (target == nums[mid]) {
            // if target is found, adjust the start index and end index accordingly.
            if (result[0] == -1) {result[0] = mid; result[1] = mid;}
            else  if (mid < result[0]) {result[0] = mid;}
            else if (mid > result[1]) {result[1] = mid;}

            // if found the target, check its's left side and right side to find the same target.
            // if found, repeat the binary search on the subrange.
            if (mid > left && nums[mid-1] == target) {searchRangeRecursive(nums, target, result, left, mid-1);}
            if (mid < right && nums[mid+1] == target) {searchRangeRecursive(nums, target, result, mid+1, right);}
        } else if (target < nums[mid]) {
            searchRangeRecursive(nums, target, result, left, mid-1);
        } else {
            searchRangeRecursive(nums, target, result, mid+1, right);
        }
    }

    /**
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     *
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     *
     * Given the sorted rotated array nums, return the minimum element of this array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
     * Example 3:
     *
     * Input: nums = [11,13,15,17]
     * Output: 11
     * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     *
     * @Leetcode - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
