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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;
        ListNode last = head;
        ListNode del = head;
        for (int i = 1; i < n; i++) {
            last = last.next;
        }
        ListNode prev = null;
        while (last.next != null) {
            last = last.next;
            prev = del;
            del = del.next;
        }
        if (prev == null)
            return del.next;
        prev.next = del.next;
        return head;
    }
}
