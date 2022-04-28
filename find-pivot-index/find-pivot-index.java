class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num: nums) sum+= num;
        
        int cur_sum = 0;
        for(int i=0; i<nums.length;i++){
            if((cur_sum) * 2 == sum - nums[i]) return i;
            cur_sum += nums[i];
        }
        return -1;
    }
}