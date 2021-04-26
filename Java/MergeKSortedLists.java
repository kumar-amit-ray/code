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
        ListNode mergedListHead = null;
        
        for (ListNode list: lists) {
            mergedListHead = merge2SortedLists(mergedListHead, list);
        }
        return mergedListHead;
    }
    
    private ListNode merge2SortedLists(ListNode head1, ListNode head2) {
        if (head1 == null) { return head2; }
        if (head2 == null) { return head1; }

        ListNode newHead = null;
        ListNode toPoint = null;

        while (head1 != null && head2 != null) {
            ListNode n;
            if (head1.val < head2.val) {
                n = head1;
                head1 = head1.next;
            } else {
                n = head2;
                head2 = head2.next;
            }
            if (newHead == null) {
                newHead = n;
                toPoint = newHead;
            } else {
                toPoint.next = n;
                toPoint = toPoint.next;
            }
        }
        ListNode remaining = (head1 == null)?head2:head1;
        while(remaining != null) {
            toPoint.next = remaining;
            toPoint = toPoint.next;
            remaining = remaining.next;

        }
        return newHead;
    }
}
