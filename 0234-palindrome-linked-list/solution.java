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
    public ListNode ReverseLL(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nextNode=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhead=ReverseLL(slow);
        ListNode cur=head;
        ListNode second=secondhead;;
        while(second!=null){
            if(cur.val!=second.val){
                return false;
            }
            cur=cur.next;
            second=second.next;
        }
        slow=ReverseLL(secondhead);
        return true;
    }
}
