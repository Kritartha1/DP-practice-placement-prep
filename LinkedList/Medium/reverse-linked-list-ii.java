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
//leetcode.com/problems/reverse-linked-list-ii/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null)return head;
        
        ListNode top=new ListNode(-1);
        top.next=head;
        ListNode pre=top;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }
        ListNode start=pre.next;
        ListNode then=start.next;
        
        //draw in white board to visualize it...
        for(int i=0;i<right-left;i++){
            start.next=then.next;
            then.next=pre.next;
            pre.next=then;
            then=start.next;
        }
        
        return top.next;
            
    }
}
