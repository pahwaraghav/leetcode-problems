class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int val : asteroids) {
            boolean take = true;
            while(!st.isEmpty() && (st.peek() > 0 &&  val < 0)) {
                if(Math.abs(st.peek()) == Math.abs(val)) {
                    st.pop();
                    take = false;
                    break;
                }
                if(Math.abs(st.peek()) > Math.abs(val)) {
                    take = false;
                    break;
                }
                else {
                    st.pop();
                }
            }
            if(take) st.push(val);
        }
        int[] res = new int[st.size()];
        if(st.size()==0) return res;
        int i = res.length-1;
        while(i>=0) res[i--] = st.pop();
        return res;
    }
}