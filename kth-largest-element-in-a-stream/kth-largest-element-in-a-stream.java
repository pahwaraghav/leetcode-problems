class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>((a,b) -> a-b);
        this.k = k;
        for(int val: nums){
            put(val);
        }
    }
    
    public int add(int val) {
        put(val);
        return pq.peek();
    }

    private void put(int val) {
        if(pq.size() < k) {
            pq.add(val);
            return;
        }
        if(!pq.isEmpty() && pq.peek() > val) return;
        if(pq.size() >= k) pq.poll();
        pq.add(val);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */