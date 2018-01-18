class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        whlie (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            prev.next = cur.next;
            cur.next = cur;
            cur.next = temp;
            prev = cur;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}