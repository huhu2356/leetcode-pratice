class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }
        
        ListNode start = cur;
        cur = cur.next;
        ListNode tail = cur;
        
        for (int i = m; i <= n; i++) {
            ListNode temp = cur.next;
            cur.next = start.next;
            start.next = cur;
            cur = temp;
        }
        
        tail.next = cur;
        
        return dummy.next;
    }
}

// 方法基本一样 不过感觉别人写的更好

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < m - 1; ++i)
            prev = prev.next;
        ListNode head2 = prev;

        prev = head2.next;
        ListNode cur = prev.next;
        for (int i = m; i < n; ++i) {
            prev.next = cur.next;
            cur.next = head2.next;
            head2.next = cur; // 头插法
            cur = prev.next;
        }
        
        return dummy.next;
    }
}