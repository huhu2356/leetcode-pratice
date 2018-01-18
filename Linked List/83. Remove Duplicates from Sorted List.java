class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }            
        }
        
        return head;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        recur(head, head.next);
        return head;
    }
    
    private void recur(ListNode prev, ListNode cur) {
        if (cur == null) return;
        
        if (prev.val == cur.val) {
            prev.next = cur.next;
            recur(prev, prev.next);
        } else {
            recur(prev.next, cur.next);
        }
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        for (ListNode prev = head, cur = head.next; cur != null; cur = prev.next) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }
        return head;
    }
}