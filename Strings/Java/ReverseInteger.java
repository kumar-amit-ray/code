/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1
 */
class Solution {
    public int reverse(int x) {
        StringBuilder xStr = new StringBuilder();
        xStr.append(Math.abs(x));
        try {
            int result = Integer.parseInt(xStr.reverse().toString());
            if (x < 0) {
                return result * -1;
            }
            return result;
        } catch(Exception e) {
            return 0;
        }  
    }
}
