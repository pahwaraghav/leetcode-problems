class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        int size = q1.size();
        for(int i=0; i<size-1;i++){
            int val = q1.poll();
            q1.offer(val);
        }
        return q1.poll();
    }
    
    public int top() {
        int ans = 0;
        while(!q1.isEmpty()){
            int val = q1.poll();
            if(q1.isEmpty()){
                ans = val;
            }
            q2.offer(val);
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ans;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */