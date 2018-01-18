class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) cur = cur.next;
            if (prev.next != cur) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode p = head.next;
        if (head.val == p.val) {
            while (p != null && p.val == head.val) {
                p = p.next;
            }
            return deleteDuplicates(p);
        } else {
            head.next = deleteDuplicates(p);
            return head;
        }
    }
}
