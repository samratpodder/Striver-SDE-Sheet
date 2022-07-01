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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(remain(head)<k) return head;//To Reverse the Last Group or not
        ListNode prev=null,next=null,curr=head;
        int count = 0;
        while(curr!=null&&count<k)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null){
            ListNode rest_head = reverseKGroup(next,k);
            head.next=rest_head;
        }
        return prev;
    }
    public int remain(ListNode head)
    {
        ListNode temp = head;
        int retVal = 0;
        while(temp!=null){
            temp=temp.next;
            retVal++;
        }
        return retVal;
    }
}
