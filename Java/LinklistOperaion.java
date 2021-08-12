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
// Rverse a list using stack
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode newHead = null;
        ListNode toPoint = null;
        while (!stack.isEmpty()) {
            if (newHead == null) {
                newHead = stack.pop();
                toPoint = newHead;
            } else {
                toPoint.next = stack.pop();
                toPoint = toPoint.next;
            }
        }
        toPoint.next = null;
        
        return newHead;
    }
}
