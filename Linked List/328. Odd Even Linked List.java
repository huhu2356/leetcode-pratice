class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        
        boolean flag = true;
        while (head != null) {
            if (flag) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            flag = ! flag;
            head = head.next;
        }
        
        odd.next = evenDummy.next;
        even.next = null;
        
        return oddDummy.next;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            
            odd.next = evenHead;
        }
        
        return head;
    }
}