class MedianFinder {

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>((a,b) -> b-a); 
        high = new PriorityQueue<>((a,b) -> a-b); 
    }
    
    public void addNum(int num) {
        if(low.isEmpty() || num > low.peek()) {
            high.add(num);
        }
        else {
            low.add(num);
            high.add(low.poll());
        }
        if(low.size() < high.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        if(low.size() > high.size()) return low.peek();
        else return (low.peek() + high.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */