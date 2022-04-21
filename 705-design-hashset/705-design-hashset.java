class MyHashSet {
    
    int[] arr;
    
    int size = 100000;

    public MyHashSet() {
        arr = new int[size];
        Arrays.fill(arr,-1);
    }
    
    public void add(int key) {
        int val = key % size;
        if(this.contains(key)){
            return;
        }
        while(arr[val] != -1){
                val = (val + 1) % size;
        }
        arr[val] = key;
    }
    
    public void remove(int key) {
        int val = key %size;
        if(!this.contains(key)){
            return;
        }
        while(arr[val] != key){
            val = (val + 1) % size;
        }
        arr[val] = -2;
    }
    
    public boolean contains(int key) {
        int val = key % size;
        while(arr[val] != -1){
            if(arr[val] == key) return true;
            val = (val + 1) % size;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */