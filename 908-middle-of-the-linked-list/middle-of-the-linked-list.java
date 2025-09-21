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
    public ListNode middleNode(ListNode head) {
        ListNode curr= head;
        int num=0;
        while(curr!=null){
            num++;
            curr=curr.next;
        }
        int odd= (num+1)/2;
        int even= (num/2)+1;

        curr=head;
        for(int i=odd;i<num;i++){
            curr=curr.next;
        }
        return curr;
    }
}