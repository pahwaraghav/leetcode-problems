class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<num.length();i++){
            char ch = num.charAt(i);
            int n = ch - '0';
            while(k > 0 && !st.isEmpty() && st.peek() > n){
                k--;
                st.pop();
            }
            st.push(n);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String ans = sb.reverse().toString();
        if(ans == ""){
            return "0";
        }
        String regex = "^0+(?!$)";
        ans = ans.replaceAll(regex, "");
        return ans;
    }
}