class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                prev = reverse(prev, next);
                count = 0;
            }
            cur = next;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode prev, ListNode end) {
        ListNode cur = prev.next;
        ListNode tail = cur;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        tail.next = end;
        
        return tail;
    }
}