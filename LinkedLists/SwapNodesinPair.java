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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
ListNode prev =  dummy;
ListNode current = head;

while(current != null && current.next != null) { 
ListNode second = current.next;
ListNode nextPair = second.next;

prev.next = second; 
second.next = current;
current.next = nextPair;


prev = current;
current = nextPair;


}
return dummy.next;
    }
}
