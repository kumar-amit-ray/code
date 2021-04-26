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
    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

@Leetcode - https://leetcode.com/problems/odd-even-linked-list/
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = null, even = null;
        
        if (head == null) {
            return null;
        }
        
        ListNode currNode = head, lastOdd = null, lastEven = null;
        int index = 1;
        
        while (currNode != null) {
            if (index % 2 == 0) {
                // even list
                if (lastEven == null) {
                    // first node in even list
                    even = currNode;
                } else {
                    lastEven.next = currNode;
                }
                lastEven = currNode;
            } else {
                //odd list
                if (lastOdd == null) {
                    // first node in odd list
                    odd = currNode;
                } else {
                    lastOdd.next = currNode;
                }
                lastOdd = currNode;
            }
            currNode = currNode.next;
            index++;
        }
        lastOdd.next = even;
        // handle the case when there is only 1 element in the input list
        if (lastEven != null) {
            // remove the loop
            lastEven.next = null;
        }
        return odd;
    }
    
}
