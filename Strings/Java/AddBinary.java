 /**
     *
     * Given two binary strings a and b, return their sum as a binary string.
     *
     *
     *
     * Example 1:
     *
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     *
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     *
     * Constraints:
     *
     * 1 <= a.length, b.length <= 104
     * a and b consist only of '0' or '1' characters.
     * Each string does not contain leading zeros except for the zero itself.
     *
     * @Leetcode - https://leetcode.com/problems/add-binary/
     */
class Solution {
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int lena = a.length()-1;
        int lenb = b.length()-1;
        int carry = 0;

        while (lena >= 0 || lenb >=0) {
            int b1 = (lena >=0)?Character.getNumericValue(a.charAt(lena)):0;
            int b2 = (lenb >=0)?Character.getNumericValue(b.charAt(lenb)):0;
            int sum = b1+b2+carry;
            if(sum <= 1) {
                carry = 0;
            } else if (sum % 2 == 0) {
                sum = 0; carry = 1; 
            } else {
                // (1+1+1)=1 but (1+1=0), so keep track of odd and even number of 1's
                sum = 1; carry = 1;
            }
            sb.append(sum);
            lena--;lenb--;
        }
        if (carry==1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
