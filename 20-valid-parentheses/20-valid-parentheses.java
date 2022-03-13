class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(isValidOpen(ch)){
                st.push(ch);
            }
            
            else if(isValidClose(ch)){
                if(st.empty()) return false;
                if(st.peek() == '(' && ch == ')'){
                    st.pop();
                }
                else if(st.peek() == '{' && ch== '}'){
                    st.pop();
                }
                else if(st.peek() == '[' && ch==']'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(!st.empty()){
            return false;
        }
        return true;
    }
    
    public boolean isValidOpen(char ch){
        if(ch == '(' || ch == '{' || ch == '['){
            return true;
        } 
        return false;
    }
    public boolean isValidClose(char ch){
        if(ch == ')' || ch== '}' || ch == ']'){
            return true;
        }
        return false;
    }
}