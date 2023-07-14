class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) {
            sum += val;
        }
        if(sum%2 != 0) return false;
        Boolean[][] arr = new Boolean[sum][nums.length];
        return helper(nums, sum/2, nums.length-1, arr);
    }
    public boolean helper(int[] nums, int target, int i, Boolean[][] arr) {
        if(target == 0) {
            return true;
        }
        if(target<0 || i<0) {
            return false;
        }
        if(arr[target][i] != null) return arr[target][i];
        boolean take = helper(nums, target - nums[i],i-1, arr);
        boolean notTake = helper(nums, target, i-1, arr);
        return arr[target][i] = take || notTake;
    }
}