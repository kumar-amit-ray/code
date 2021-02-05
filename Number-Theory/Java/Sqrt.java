/**
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

@Leetcode - https://leetcode.com/problems/sqrtx/
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long start = 1, end = x, ans=0;
        while (start <= end) {
            long mid = start+(end-start)/2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int)(start)-1;
    }
}
