class Solution {
    int res;
    public int countVowelStrings(int n) {
        helper(n,0,0);
        return res;
    }
    public void helper(int n, int i, int j){
        if(i>=5){
            return;
        }
        if(j==n){
            res++;
            return;
        }
        helper(n,i+1,j);
        helper(n,i,j+1);
    }
}