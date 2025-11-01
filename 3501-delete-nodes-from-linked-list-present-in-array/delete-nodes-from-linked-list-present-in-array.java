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
    public ListNode modifiedList(int[] nums, ListNode head) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Adjust head in case its value is in nums
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        // If list is empty after removing invalid heads
        if (head == null) return null;

        ListNode current = head;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next; // remove the node
            } else {
                current = current.next;
            }
        }

        return head;
    }
}