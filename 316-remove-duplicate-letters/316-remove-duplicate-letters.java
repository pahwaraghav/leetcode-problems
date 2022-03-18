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

        StringBuilder sbr = new StringBuilder();
        sbr.setLength(st.size());
        int i= st.size()-1;
        while(!st.empty()){
            int n = st.pop() + 'a';
            char ch = (char)n ;
            sbr.setCharAt(i,ch);
            i--;
        }
        res = sbr.toString();
        return res;
    }
}