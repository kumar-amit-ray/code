/*
	12. Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal 
  to the product of all the elements of nums except nums[i].
	Example:
	Input:  [1,2,3,4]
Output: [24,12,8,6]
	Note: Please solve it without division and in O(n).
	Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for 
the purpose of space complexity analysis.)
Youtube - https://www.youtube.com/watch?v=vB-81TB6GUc
*/

void productExceptSelf(int *nums, int len)
{
  int result[len];

  for (int i = 0, tmp = 1; i < len; i++) {
    result[i] = tmp;
    tmp *= nums[i];
    printf("\nResult[%d]=%d, tmp=%d", i, result[i], tmp);
  }

  for (int i = len - 1, tmp = 1; i >= 0; i--) {
    result[i] *= tmp;
    tmp *= nums[i];
    printf("\nResult[%d]=%d, tmp=%d", i, result[i], tmp);
  }
}

