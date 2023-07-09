class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,0,0,"", ans);
        return ans;
    }
    public void helper(int n, int open, int closed, String curr, List<String> ans){
        if((open + closed) == 2*n && open == closed){
            ans.add(curr);
            return;
        }
        if(open > n) return;
        helper(n, open+1, closed, curr+"(", ans);
        if(open > closed){
            helper(n, open, closed+1, curr+")", ans);
        }
    }
}