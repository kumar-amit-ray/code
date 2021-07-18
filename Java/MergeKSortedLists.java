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
 @Leetcode - https://leetcode.com/problems/merge-k-sorted-lists/
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 ) {
            return null;
        }
        ListNode newHead = null;
        for (int i=0; i<lists.length; i++) {
            newHead = merge2Lists(newHead, lists[i]);
        }
        return newHead;
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    curr = head;
                } else {
                    curr.next = l1;
                    curr = curr.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    curr = head;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        
        return head;
    }
}
