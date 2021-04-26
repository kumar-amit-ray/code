/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
@Leetcode -  https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode startLoop = null;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findLoopStart(slow, head);
            }
        }
        return null;
    }
    
    private ListNode findLoopStart(ListNode loopNode, ListNode head) {
        ListNode slow = head, fast = loopNode;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
