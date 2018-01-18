class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        slow = reverse(slow);
        
        ListNode cur = head;
        while (cur.next != null) {
            ListNode curNext = cur.next;
            ListNode slowNext = slow.next;
            cur.next = slow;
            slow.next = curNext;
            cur = curNext;
            slow = slowNext;
        }
        cur.next = slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode dummy = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        
        return dummy;
    }
}