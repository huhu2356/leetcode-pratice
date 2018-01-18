public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyCur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        while (cur != null) {
            copyCur.next = new RandomListNode(cur.label);
            copyCur = copyCur.next;
            map.put(cur, copyCur);
            cur = cur.next;
        }
        
        cur = head;
        while (cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        
        return dummy.next;
    }
}


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }            
            cur = cur.next.next;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyCur = dummy;
        cur = head;
        while (cur != null) {
            copyCur.next = cur.next;
            copyCur = copyCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
    
        return dummy.next;    
    }
}