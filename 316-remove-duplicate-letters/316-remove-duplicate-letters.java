class Solution {
    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];
        int[] filled = new int[26];
        Stack<Integer> st = new Stack<Integer>();
        String res = "";
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            int n = ch - 'a';
            arr[n]++;
        }
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int n = ch - 'a';
            if(filled[n] == 0){
                while(!st.empty() && st.peek() > n && arr[st.peek()] > 0){
                    filled[st.peek()] = 0;
                    st.pop();
                }
                st.push(n);
                filled[n] =1;
            }
            arr[n]--;
        }
        while(!st.empty()){
            int n = st.pop() + 'a';
            char ch = (char)n ;
            res += ch;
        }
        StringBuffer sbr = new StringBuffer(res);
        sbr.reverse();
        return sbr.toString();
    }
}