class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            String str = tokens[i];
            if(isOperator(str)) {
                int operand1 = st.pop();
                int operand2 = st.pop();
                st.push(evaluate(operand2, operand1, str));
            }
            else {
                st.push(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
    public boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    public int evaluate(int operand1, int operand2, String operator) {
        if(operator.equals("+")) return operand1 + operand2;
        if(operator.equals("-")) return operand1 - operand2;
        if(operator.equals("*")) return operand1 * operand2;
        else return operand1 / operand2;
    }
}