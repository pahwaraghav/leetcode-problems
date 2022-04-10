class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<ops.length;i++){
            String s = ops[i];
            char ch = s.charAt(0);
            if(ch == '+'){
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(num2);
                st.push(num1);
                st.push(num1 + num2);
            }
            else if(ch == 'D'){
                int num = st.peek();
                st.push(2 * num);
            }
            else if(ch == 'C'){
                st.pop();
            }
            else{
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        int res = 0;
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }
}