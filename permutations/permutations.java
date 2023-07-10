class Solution {
    int min = Integer.MIN_VALUE;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, curr, ans);
        return ans;
    }
    public void helper(int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == min) continue;
            curr.add(nums[i]);
            int temp = nums[i];
            nums[i] = min;
            helper(nums, curr, ans);
            curr.remove(curr.size()-1);
            nums[i] = temp;
        }
    }
}

