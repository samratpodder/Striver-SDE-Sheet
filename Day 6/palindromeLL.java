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
    public boolean isPalindrome(ListNode head) {
        if(head==null|| head.next==null) return true;
        ListNode mid = getMidNode(head);
        ListNode sHead = reverseList(mid);
        while(sHead!=null)
        {
            if(head.val!=sHead.val) return false;
            head=head.next;
            sHead = sHead.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head)
    {
        if(head.next==null) return head; 
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode getMidNode(ListNode head)
    {
        ListNode fast= head, slow = head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}