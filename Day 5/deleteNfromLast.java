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
        if(head==null | head.next==null) return null;
        ListNode dummy = new ListNode();// Dummy is needed to create the proper distance of n between slow and fast pointers
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for(int i=1; i<=n+1; i++){
            fast = fast.next;
        }
        while(fast!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}