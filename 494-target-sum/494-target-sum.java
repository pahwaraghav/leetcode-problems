class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
    }
    public int helper(int[] nums,int target, int i,int sum){
        if(i==nums.length){
            if(target == sum){
                return 1;
            }
            return 0;
        }
        return helper(nums,target,i+1, sum+nums[i]) + helper(nums,target,i+1, sum-nums[i]);
    }
}