class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> min;
    public MinStack() {
        stack = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(min.size()==0){
            min.add(val);
            return;
        }
        if(val < min.get(min.size()-1)){
            min.add(val);
        }
        else{
            min.add(min.get(min.size()-1));
        }
    }
    
    public void pop() {
        if(stack.size() == 0) return;
        stack.remove(stack.size()-1);
        min.remove(min.size()-1);
    }
    
    public int top() {
        if(stack.size()==0) return -1;
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        if(min.size() == 0) return -1;
        return min.get(min.size()-1);   
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */