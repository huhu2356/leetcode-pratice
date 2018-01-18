class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node first;
    private Node last;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val= value;
            remove(n);
            setHead(n);
        } else {
            Node n = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(last.key);
                remove(last);
                setHead(n);
            } else {
                setHead(n);
            }
            map.put(key, n);
        }
    }
     
    private void remove(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            first = n.next;
        }
        
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            last = n.prev;
        }
    }
    
    private void setHead(Node n) {
        n.next = first;
        n.prev = null;
        
        if (first != null) first.prev = n;
        first = n;
        
        if (last == null) last = first;
    }
}