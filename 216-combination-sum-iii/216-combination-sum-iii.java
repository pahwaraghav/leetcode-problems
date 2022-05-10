class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(k,n,1,0,res,cur);
        return res;
    }
    public void helper(int k, int n, int i, int sum, List<List<Integer>> res, List<Integer> curr){
        if(sum == n  && curr.size() == k){
            List<Integer> lis = new ArrayList<>(curr);
            res.add(lis);
            return;
        }
        if(i>9 || curr.size() > k || sum > n){
            return;
        }
        curr.add(i);
        helper(k,n,i+1,sum+i,res,curr);
        curr.remove(curr.size()-1);
        helper(k,n,i+1,sum,res,curr);
    }
}