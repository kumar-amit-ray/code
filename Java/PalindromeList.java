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
@Leetcode - https://leetcode.com/problems/palindrome-linked-list/
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode reverseStart = reverseFromGivenNode(middle);
        ListNode start = head;

        while (reverseStart != null && start != null) {
            if (reverseStart.val != start.val) {
                return false;
            }
            reverseStart = reverseStart.next;
            start = start.next;
        }
        return true;
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseFromGivenNode(ListNode start) {
        ListNode curr = start;
        ListNode pointTo = null;
        ListNode toPoint = null;

        while(curr != null) {
            pointTo = curr;
            curr = curr.next;
            pointTo.next = toPoint;
            toPoint = pointTo;
        }
        return toPoint;
    }    
}
