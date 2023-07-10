class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>(), ans);
        return ans;
    }
    public void helper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> ans) {
        if(idx == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        helper(nums,idx+1, curr, ans);
        curr.remove(curr.size()-1);
        helper(nums,idx+1, curr, ans);
    }
}