class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i =0; i<sb.length(); i++){
            if(sb.charAt(i) == '(') st.push(i);
            else if(sb.charAt(i) == ')'){
                if(!st.empty()) st.pop();
                else sb.setCharAt(i,'*');
            }
        }
        while(!st.empty()){
            sb.setCharAt(st.pop(),'*');
        }
        return sb.toString().replaceAll("\\*", "");
    }
}