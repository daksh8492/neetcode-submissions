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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode sec = mid.next;
        mid.next = null;
        sec = reverse(sec);
        mid.next = null;
        ListNode fir = head;
        while (fir != null && sec != null) {
            ListNode temp = fir.next;
            fir.next = sec;
            sec = sec.next;
            fir.next.next = temp;
            fir = fir.next.next;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null, cur = head, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
