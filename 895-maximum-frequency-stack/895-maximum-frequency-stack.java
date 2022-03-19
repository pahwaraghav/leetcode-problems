class FreqStack {
    
    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> hmap;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<Integer,Integer>();
        hmap = new HashMap<>();
        maxFreq =0;
    }
    
    public void push(int val) {
        int n = freq.getOrDefault(val,0) + 1;
        freq.put(val,n);
        maxFreq = Math.max(maxFreq,n);
        if(!hmap.containsKey(n)){
            hmap.put(n,new Stack<Integer>());
        }
        hmap.get(n).add(val);
    }
    
    public int pop() {
        int val = hmap.get(maxFreq).pop();
        freq.put(val,maxFreq-1);
        if(hmap.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */