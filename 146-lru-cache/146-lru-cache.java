class LRUCache extends LinkedHashMap<Integer,Integer> {
    LinkedHashMap<Integer,Integer> lHMap;
    private int size;
    public LRUCache(int capacity) {
        lHMap = new LinkedHashMap<>();
        size = capacity;
    }
    
    public int get(int key) {
        if(lHMap.containsKey(key)){
            int val = lHMap.get(key);
            lHMap.remove(key);
            lHMap.put(key,val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(lHMap.containsKey(key)){
            lHMap.remove(key);
            lHMap.put(key,value);
        }
        else{
            if(lHMap.size() == size){
                lHMap.remove(lHMap.keySet().iterator().next());
            }
            lHMap.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */