class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int cur_min = nums[0];
        int cur_max = nums[0];
        for(int i=1; i<nums.length;i++){
            int temp = cur_min;
            cur_min = Math.min(nums[i], Math.min(cur_min*nums[i], cur_max*nums[i]));
            cur_max = Math.max(nums[i], Math.max(temp*nums[i],cur_max*nums[i]));       
            res = Math.max(res,Math.max(cur_min,cur_max));
        }
        return res;
    }
}