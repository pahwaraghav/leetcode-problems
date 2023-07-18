class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer,Node> hmap;
    int capacity;

    public LRUCache(int capacity) {
        hmap = new HashMap<>();
        head = new Node();
        head.next = new Node();
        tail = head.next;
        head.next.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)) {
            Node n = hmap.get(key);
            popAndMoveToFirst(n);
            //print();
            return n.val;
        }
        return -1;
    }

    public void pop(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addToFirst(Node n) {
        Node next = head.next;
        head.next = n;
        n.prev = head;
        n.next = next;
        next.prev = n;
    }

    public void popAndMoveToFirst(Node n) {
        pop(n);
        addToFirst(n);
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)) {
            Node n = hmap.get(key);
            n.val = value;
            this.get(key);
        }
        else {
            if(capacity == 0) {
                hmap.remove(tail.prev.key);
                Node secondLast = tail.prev.prev;
                secondLast.next = tail;
                tail.prev = secondLast;
            }
            else {
                capacity--;
            }
            Node n = new Node(key, value);
            hmap.put(key,n);
            Node next = head.next;
            head.next = n;
            n.prev = head;
            n.next = next;
            next.prev = n;
        }
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int val;
    Node() {}
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
    Node(int val) {
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */