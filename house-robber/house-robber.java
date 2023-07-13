class Solution {
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem,-1);
        int last = helper(nums, nums.length-1, mem);
        Arrays.fill(mem,-1);
        int secondLast = helper(nums, nums.length-2, mem);
        return Math.max(last,secondLast);
    }
    public int helper(int[] nums, int i, int[] dp) {
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + helper(nums, i-2, dp);
        int notTake = helper(nums, i-1, dp);
        return dp[i] = Math.max(take, notTake);
    }
}