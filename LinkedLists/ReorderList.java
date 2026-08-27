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
        ListNode slow = head;
        ListNode fast = head;
        ListNode second = head;
        ListNode previous = null;

        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        second = slow.next;
        slow.next = null;

        while( second != null ){
            ListNode next = second.next;
            second.next = previous;
            previous = second;
            second = next;
        }

        ListNode first = head ;
        second = previous ;

        while (second != null ) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext ;
            second = secondNext ;
        }
    }
}
