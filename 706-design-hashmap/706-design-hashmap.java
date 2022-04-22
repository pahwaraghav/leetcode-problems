class Pair{
    int key;
    int val;
    Pair(){}
    Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {
    Pair[] arr;
    int size = 100001;

    public MyHashMap() {
        arr = new Pair[size];
    }
    
    public void put(int key, int value) {
        int hash = key % size;
        while(arr[hash] != null){
            if(arr[hash].key == key || arr[hash].key == -1){
                break;
            }
            hash = (hash+1) % size;
        }
        Pair p = new Pair(key,value);
        arr[hash] = p;
    }
    
    public int get(int key) {
        int hash = key % size;
        while(arr[hash] != null){
            if(arr[hash].key == key){
                return arr[hash].val;
            }
            hash = (hash+1) % size;
        }
        return -1;
    }
    
    public void remove(int key) {
        if(get(key) == -1){
            return;
        }
        int hash = key % size;
        while(arr[hash] != null){
            if(arr[hash].key == key || arr[hash].key == -1){
                break;
            }
            hash = (hash+1) % size;
        }
        arr[hash].key = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */