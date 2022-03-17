class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int curr = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                st.push(curr);
                curr = 0;
            }
            else{
                curr = st.pop() + Math.max(curr*2,1);
            }
        }
        return curr;
    }
}