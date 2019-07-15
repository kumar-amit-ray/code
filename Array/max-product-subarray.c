/*
	Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
	Example 1:
	Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
	Example 2:
	Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Youtube Link : https://www.youtube.com/watch?v=vtJvbRlHqTA
*/
  

int max3(int a, int b, int c) {
    if (a>=b && a>=c) return a;
    else if (b>=a && b>=c) return b;
    else return c;
}

int min3(int a, int b, int c) {
    if (a<=b && a<=c) return a;
    else if (b<=a && b<=c) return b;
    else return c;
}

int max2(int a, int b) {
    if (a>=b)  return a;
    return b;
}

int maxProduct(int* nums, int numsSize) {
    if (numsSize == 0) return 0;
    if (numsSize == 1) return nums[0];
    
    int cur_prod_max = nums[0];
    int cur_prod_min = nums[0];
    int prev_prod_max = nums[0];
    int prev_prod_min = nums[0];
    int ans = nums[0];
    
    for (int i=1; i<numsSize; i++) {
        cur_prod_max = max3(prev_prod_max*nums[i], prev_prod_min*nums[i], nums[i]);
        cur_prod_min = min3(prev_prod_max*nums[i], prev_prod_min*nums[i], nums[i]);
        ans = max2(ans, cur_prod_max);
        prev_prod_max = cur_prod_max;
        prev_prod_min = cur_prod_min;
    }
    return ans;
}

In Python
=========
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_product=nums[0]
        prev_max_product = nums[0]
        min_product = nums[0]
        prev_min_product = nums[0]
        result = nums[0]
        i=1
        while i<len(nums):
            max_product = max(prev_max_product*nums[i], prev_min_product*nums[i], nums[i])
            min_product = min(prev_max_product*nums[i], prev_min_product*nums[i], nums[i])
            result = max(result, max_product)
            prev_max_product = max_product
            prev_min_product = min_product
            i +=1
        return result
