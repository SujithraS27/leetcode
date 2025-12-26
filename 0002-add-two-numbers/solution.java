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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode head=null;
        ListNode temp=null;
        int carry=0;
        
        while(cur1!=null || cur2!=null){
            int sum=carry;
            if(cur1!=null){
                sum=sum+cur1.val;
                cur1=cur1.next;
            }
            if(cur2!=null){
                sum=sum+cur2.val;
                cur2=cur2.next;
            }
            ListNode nn=new ListNode(sum%10);
            carry=sum/10;
            
            if(head==null){
                head=nn;
                temp=nn;
            }
            else{
                temp.next=nn;
                temp=nn;
            }
            
        }
        if(carry>0){
                ListNode nc=new ListNode(carry);
                temp.next=nc;
            }
        return head;
    }
}
