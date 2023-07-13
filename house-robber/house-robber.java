class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if(nums.length > 2) dp[2] = Math.max(nums[0] + nums[2], nums[1]);
        for(int i=3; i<nums.length; i++) {
            int take = nums[i] + dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
}