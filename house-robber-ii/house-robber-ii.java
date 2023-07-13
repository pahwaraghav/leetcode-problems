class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int one = helper(nums,0, nums.length-2, dp);
        Arrays.fill(dp,-1);
        int two = helper(nums,1, nums.length-1, dp);
        return Math.max(one, two);
    }
    public int helper(int[] nums, int i, int len, int[] dp) {
        if(i>len) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + helper(nums, i+2, len, dp);
        int notTake = helper(nums, i+1, len, dp);
        return dp[i] = Math.max(take, notTake);
    }
}