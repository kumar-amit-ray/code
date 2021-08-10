/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and 
each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

@Leetcode - https://leetcode.com/problems/add-two-numbers/
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode toPoint = null;
        int c = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;
            
            if (l1 != null) {v1 = l1.val;l1 = l1.next;}
            if (l2 != null) {v2 = l2.val;l2 = l2.next;}
            
            int sum = v1 + v2 + c;
            if (sum >= 10) {
                sum = sum - 10;
                c = 1;
            } else {
                c = 0;
            }
            
            ListNode curr = new ListNode(sum, null);
            if (result == null) {
                result = curr;
                toPoint = curr;
            } else {
                toPoint.next = curr;
                toPoint = toPoint.next;
            }
        }
        if (c != 0) {
            toPoint.next = new ListNode(c, null);
        }
        return result;
    }
}
