class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<Integer>();
        int i =0;
        for(int num : pushed){
            st.push(num);
            while(!st.empty() && st.peek() == popped[i]){
                st.pop();
                i++;
            }
        }
    return st.empty();
    }
}