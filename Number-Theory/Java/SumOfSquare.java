/**
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
Example 3:

Input: c = 4
Output: true
Example 4:

Input: c = 2
Output: true
Example 5:

Input: c = 1
Output: true

@Leetcode - https://leetcode.com/problems/sum-of-square-numbers/
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        // Math.sqrt() takes double. Conver c to double by multiplying 1.0.
        // s = 0 because when c=1, we need to return 'true' as 0^2+1^2
        int s = 0, e = (int)Math.sqrt(1.0 * c);
        
        while (s <= e) {
            int expr = s * s + e * e;
            if (expr == c) {
                return true;
            } else if (expr > c) {
                e--;
            } else {
                s++;
            }
        }
        return false;
    }
}
