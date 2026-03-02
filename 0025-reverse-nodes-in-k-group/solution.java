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
    public boolean exists(ListNode curr,int k){
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
            if(count==k){
                return true;
            }
        }
        
        return false;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev=null;
        ListNode curr=head;
        int count=0;
        while(curr!=null && count<k){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            count++;
        }
        if(exists(curr,k)){
            head.next=reverseKGroup(curr,k);
        }
        else{
            head.next=curr;
        }

        return prev;
    }
}
