class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n;i++){
            if(s.charAt(i) == '(') st.push(i);
            else{
                if(!st.isEmpty()){
                    if(s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if(st.isEmpty()) ans = n;
        else{
            int i = n;
            int j= 0;
            while(!st.isEmpty()){
                j = st.pop();
                ans = Math.max(ans,i-j-1);
                i = j;
            }
            ans = Math.max(ans,i);
        }
        return ans;
    }
}