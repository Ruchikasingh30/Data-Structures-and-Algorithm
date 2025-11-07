class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Create a dummy head node. This simplifies the process 
        // by avoiding special handling for the very first node.
        ListNode dummyHead = new ListNode(0);
        // 'current' pointer is used to build the result list.
        ListNode current = dummyHead;
        
        // 2. Initialize the carry variable.
        int carry = 0;
        
        // 3. Loop as long as there are digits in either list OR there is a carry.
        while (l1 != null || l2 != null || carry > 0) {
            
            // Get the value of the current nodes, treating null as 0.
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Calculate the sum for the current place value.
            int sum = carry + x + y;
            
            // Update the carry for the next place value.
            // (e.g., if sum is 17, carry becomes 1)
            carry = sum / 10;
            
            // The digit for the new node is the remainder (sum % 10).
            // (e.g., if sum is 17, the new digit is 7)
            current.next = new ListNode(sum % 10);
            
            // Move the current pointer to the newly created node.
            current = current.next;
            
            // Advance the input list pointers if they are not null.
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        
        // The result list is the node immediately following the dummy head.
        return dummyHead.next;
    }
}