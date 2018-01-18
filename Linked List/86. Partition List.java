class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left_dummy = new ListNode(0);
        ListNode right_dummy = new ListNode(0);
        
        ListNode left_cur = left_dummy;
        ListNode right_cur = right_dummy;
        
        while (head != null) {
            if (head.val < x) {
                left_cur.next = head;
                left_cur = left_cur.next;
            } else {
                right_cur.next = head;
                right_cur = right_cur.next;
            }
            head = head.next;
        }
        
        left_cur.next = right_dummy.next;
        right_cur.next = null;
        
        return left_dummy.next;
    }
}